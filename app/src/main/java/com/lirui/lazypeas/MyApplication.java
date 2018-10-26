package com.lirui.lazypeas;

import android.app.Application;

import com.lirui.lazypeas.library.http.HttpUtilConfig;
import com.lirui.lazypeas.library.util.ApplicationInUtil;
import com.lirui.lazypeas.library.view.statusview.StatusViewConfig;

/**
 * Created by lirui on 2018/3/6.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        StatusViewConfig.CONFIG
                .setConfigErrorResId(R.layout.state_view_error)
                .setConfigEmptyResId(R.layout.state_view_empty)
                .setConfigLoadingResId(R.layout.state_view_loading)
                .setConfigNetWorkErrorResId(R.layout.state_view_network_error);

        HttpUtilConfig.CONFIG
                .setReadTimeOut(10000)
                .setConnectTimeOut(10000)
                .setBaseDebugUrl("http://www.wanandroid.com/")
                .setBaseOnLineUrl("http://www.wanandroid.com/");

        ApplicationInUtil.initContext(this);
    }
}
