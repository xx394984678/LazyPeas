package com.lirui.lazypeas.library.util;

import android.content.res.Resources;
import android.util.TypedValue;

public class ScreenUtils {
    public static float dpToPixel(float dp) {
        return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().getDisplayMetrics());
    }

//    public static Bitmap getAvatar(Resources res, int width) {
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inJustDecodeBounds = true;
//        BitmapFactory.decodeResource(res, R.drawable.avatar_rengwuxian, options);
//        options.inJustDecodeBounds = false;
//        options.inDensity = options.outWidth;
//        options.inTargetDensity = width;
//        return BitmapFactory.decodeResource(res, R.drawable.avatar_rengwuxian, options);
//    }

    public static float getZForCamera() {
        return - 6 * Resources.getSystem().getDisplayMetrics().density;
    }
}
