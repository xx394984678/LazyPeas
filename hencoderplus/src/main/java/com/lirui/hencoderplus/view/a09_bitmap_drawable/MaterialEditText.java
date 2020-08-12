package com.lirui.hencoderplus.view.a09_bitmap_drawable;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.Keep;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;

import com.lirui.hencoderplus.R;
import com.lirui.lazypeas.library.util.ScreenUtils;

public class MaterialEditText extends android.support.v7.widget.AppCompatEditText {
    private static final String TAG = "MaterialEditText";

    private static final float TEXT_SIZE = ScreenUtils.dpToPixel(12);
    private static final float TEXT_MARGIN = ScreenUtils.dpToPixel(20);

    private static final float TEXT_ALIGN = ScreenUtils.dpToPixel(22);
    private static final float TEXT_ALIGN_OFFSET = ScreenUtils.dpToPixel(5);

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    //漂浮的条是否在显示中
    private boolean floatingLabelShown = false;
    private float floatingLabelFraction;

    private ObjectAnimator objectAnimator;
    public MaterialEditText(Context context) {
        this(context, null);
    }

    public MaterialEditText(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.editTextStyle);
    }

    public MaterialEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    {
        paint.setTextSize(TEXT_SIZE);
        paint.setStrokeWidth(ScreenUtils.dpToPixel(3));
        paint.setColor(getResources().getColor(R.color.status_view_reload));
        setPadding(getPaddingLeft(), (int) (getPaddingTop() + TEXT_SIZE + TEXT_MARGIN), getPaddingRight(), getPaddingBottom());
    }
    private void initAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
//            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MaterialEditText);
//
//            typedArray.recycle();
        }
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        initAttrs(context, attrs);

        addTextChangedListener(textWatcher);
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (TextUtils.isEmpty(s)&&floatingLabelShown) {
                floatingLabelShown = false;
                getAnimator().reverse();
            } else if (!floatingLabelShown && !TextUtils.isEmpty(s)) {
                floatingLabelShown = true;
                getAnimator().start();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private ObjectAnimator getAnimator(){
        if (objectAnimator == null) {
            objectAnimator = ObjectAnimator.ofFloat(this, "floatingLabelFraction", 0, 1);
        }
        return objectAnimator;
    }

    public float getFloatingLabelFraction() {
        return floatingLabelFraction;
    }

    @Keep
    public void setFloatingLabelFraction(float floatingLabelFraction) {
        this.floatingLabelFraction = floatingLabelFraction;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAlpha((int) (255 * floatingLabelFraction));
        int textAlign = (int) (TEXT_ALIGN + (1 - floatingLabelFraction) * TEXT_ALIGN_OFFSET);
        if (getHint() != null) {
            canvas.drawText(getHint().toString(), getPaddingLeft(), textAlign, paint);
        }

    }
}