package com.lirui.lazypeas.library.view.stateview;

import android.app.Activity;
import android.app.Fragment;
import android.view.View;

/**
 * Created by lirui on 2018/3/6.
 */

public class StateViewBuilder {
    int enterType;
    Activity activity;
    Fragment fragment;
    View view;

    int stateViewErrorResId = StateViewConfig.CONFIG.errorResId;
    int stateViewEmptyResId = StateViewConfig.CONFIG.emptyResId;
    int stateViewLoadingResId = StateViewConfig.CONFIG.loadingResId;
    int stateViewNetWorkErrorResId = StateViewConfig.CONFIG.netWorkErrorResId;
    StateView.StateViewReloadListener stateViewReloadListener;

    private StateViewBuilder() {

    }


    public StateViewBuilder(Activity activity) {
        if (activity == null) {
            throw new NullPointerException("activity can not be null");
        }
        this.activity = activity;
        enterType = StateViewConfig.STATE_VIEW_BUILDER_ACTIVITY_TYPE;
    }

    public StateViewBuilder(Fragment fragment) {
        if (fragment == null) {
            throw new NullPointerException("fragment can not be null");
        }
        this.fragment = fragment;
        enterType = StateViewConfig.STATE_VIEW_BUILDER_FRAGMENT_TYPE;
    }

    public StateViewBuilder(View view) {
        if (view == null) {
            throw new NullPointerException("activity can not be null");
        }
        this.view = view;
        enterType = StateViewConfig.STATE_VIEW_BUILDER_VIEW_TYPE;
    }


    public StateViewBuilder setStateViewErrorResId(int stateViewErrorResId) {
        this.stateViewErrorResId = stateViewErrorResId;
        return this;
    }

    public StateViewBuilder setStateViewEmptyResId(int stateViewEmptyResId) {
        this.stateViewEmptyResId = stateViewEmptyResId;
        return this;
    }

    public StateViewBuilder setStateViewLoadingResId(int stateViewLoadingResId) {
        this.stateViewLoadingResId = stateViewLoadingResId;
        return this;
    }

    public StateViewBuilder setStateViewNetWorkErrorResId(int stateViewNetWorkErrorResId) {
        this.stateViewNetWorkErrorResId = stateViewNetWorkErrorResId;
        return this;
    }

    public StateViewBuilder setStateViewReloadListener(StateView.StateViewReloadListener stateViewReloadListener) {
        this.stateViewReloadListener = stateViewReloadListener;
        return this;
    }

    public StateView build() {
        return StateView.createWithBuilder(this);
    }
}
