package com.lirui.lazypeas.library.view.statusview;

import com.lirui.lazypeas.library.R;

/**
 * Created by lirui on 2018/3/6.
 */

public class StatusViewConfig {
//    static final int STATE_VIEW_BUILDER_ACTIVITY_TYPE = 1;
//    static final int STATE_VIEW_BUILDER_FRAGMENT_TYPE = 2;
//    static final int STATE_VIEW_BUILDER_VIEW_TYPE = 3;

    static final int CONTENT_RES_ID = -1;
    int errorResId = R.layout.state_view_error;
    int netWorkErrorResId = R.layout.state_view_network_error;
    int emptyResId = R.layout.state_view_empty;
    int loadingResId = R.layout.state_view_loading;

    public static final StatusViewConfig CONFIG = new StatusViewConfig();

    private StatusViewConfig() {

    }

    public StatusViewConfig setConfigErrorResId(int errorResId) {
        this.errorResId = errorResId;
        return this;
    }
    public StatusViewConfig setConfigEmptyResId(int emptyResId) {
        this.emptyResId = emptyResId;
        return this;
    }
    public StatusViewConfig setConfigLoadingResId(int loadingResId) {
        this.loadingResId = loadingResId;
        return this;
    }
    public StatusViewConfig setConfigNetWorkErrorResId(int netWorkErrorResId) {
        this.netWorkErrorResId = netWorkErrorResId;
        return this;
    }
}
