package com.lirui.hencoderplus.view.a09_bitmap_drawable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.lirui.lazypeas.library.util.ScreenUtils;

public class MeshDrawable extends Drawable {
    private static final int INTERVAL = (int) ScreenUtils.dpToPixel(80);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(ScreenUtils.dpToPixel(2));
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.save();
//        canvas.rotate(45,getBounds().left,getBounds().top);
        //竖线
        for (int i = getBounds().left; i < getBounds().right; i += INTERVAL) {
            canvas.drawLine( i, getBounds().top,  i, getBounds().bottom, paint);
        }
        //横线
        for (int j = getBounds().top; j < getBounds().bottom; j += INTERVAL) {
            canvas.drawLine(getBounds().left, j, getBounds().right,  j, paint);
        }
        canvas.restore();
    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public int getAlpha() {
        return paint.getAlpha();
    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return paint.getAlpha() == 0 ? PixelFormat.TRANSPARENT :
                paint.getAlpha() == 0xff ? PixelFormat.OPAQUE : PixelFormat.TRANSLUCENT;
    }
}
