package com.lirui.lazypeas.library.util;

import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    public static void showToast(String msg){
        if (toast == null) {
            toast = Toast.makeText(ApplicationInUtil.getContext(), msg, Toast.LENGTH_SHORT);
            toast.show();
        } else {
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
