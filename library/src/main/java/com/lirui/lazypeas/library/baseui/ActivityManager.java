package com.lirui.lazypeas.library.baseui;

import android.app.Activity;

import com.lirui.lazypeas.library.util.LogUtilInLibrary;

import java.util.ArrayList;

/**
 * Created by lirui on 2018/3/2.
 */

public class ActivityManager {
    private static ArrayList<Activity> activities = new ArrayList<>();

    private ActivityManager() {
    }

    public static void newActivity(Activity newActivity) {
        if (newActivity == null) {
            LogUtilInLibrary.eWithDefaultTag("u have a unexpected problem");
            return;
        }
        activities.add(newActivity);
    }

    public static void removeActivity(Activity activity) {
        if (activity == null) {
            LogUtilInLibrary.eWithDefaultTag("u have a unexpected problem");
            return;
        }
        activities.remove(activity);
    }

    /**
     * 结束所有activity
     */
    public static void allFinishActivity() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        activities.clear();
    }
}
