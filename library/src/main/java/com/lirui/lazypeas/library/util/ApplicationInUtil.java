package com.lirui.lazypeas.library.util;

import android.app.Application;

public class ApplicationInUtil {
    private static Application application;

    public static void initContext(Application application) {
        ApplicationInUtil.application = application;
    }

    public static Application getContext() {
        return application;
    }
}
