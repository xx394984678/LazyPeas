package com.lirui.hencoderplus.view.a09_bitmap_drawable;

import android.content.Context;
import android.graphics.Canvas;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class DrawableView extends View {
    MeshDrawable drawable;

    {
        drawable = new MeshDrawable();
    }

    public DrawableView(Context context) {
        this(context, null);
    }

    public DrawableView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawable.setBounds(500, 0, getWidth(), getHeight()-500);
        drawable.draw(canvas);

    }
}
