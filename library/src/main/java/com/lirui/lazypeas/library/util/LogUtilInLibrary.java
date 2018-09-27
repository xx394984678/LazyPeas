package com.lirui.lazypeas.library.util;

import android.util.Log;

public class LogUtilInLibrary {
    private static final String TAG = "LogUtilInLibrary";
    private static boolean isPrintLog = true;

    public static void setIsPrintLog(boolean isPrintLog) {
        LogUtilInLibrary.isPrintLog = isPrintLog;
    }

    public static void d(String tag, String value) {
        if (!isPrintLog) {
            return;
        }
        Log.d(tag, value);
    }

    public static void dWithDefaultTag(String value) {
        d(TAG, value);
    }

    public static void e(String tag, String value) {
        if (!isPrintLog) {
            return;
        }
        Log.e(tag, value);
    }

    public static void eWithDefaultTag(String value) {
        e(TAG, value);
    }
}
