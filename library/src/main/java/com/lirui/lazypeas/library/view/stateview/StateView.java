package com.lirui.lazypeas.library.view.stateview;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.lirui.lazypeas.library.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lirui on 2018/3/2.
 */

public class StateView extends FrameLayout implements View.OnClickListener {
    private LayoutInflater mInflater;
    private Map<Integer, View> mResIdMap = new HashMap<>();

//    private int errorResId = StateViewDefaultConfig.ERROR_RES_ID;
//    private int emptyResId = StateViewDefaultConfig.EMPTY_RES_ID;
//    private int loadingResId = StateViewDefaultConfig.LOADING_RES_ID;
//    private int netWorkErrorResId = StateViewDefaultConfig.NETWORK_ERROR_RES_ID;

    private int errorResId = 0;
    private int emptyResId = 0;
    private int loadingResId = 0;
    private int netWorkErrorResId = 0;
    private StateViewReloadListener stateViewReloadListener;

    public StateView(@NonNull Context context) {
        this(context, null);
    }

    public StateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
    }

    public static StateViewBuilder newStateView(Activity activity) {
        return new StateViewBuilder(activity);
    }

    public static StateViewBuilder newStateView(Fragment fragment) {
        return new StateViewBuilder(fragment);
    }

    public static StateViewBuilder newStateView(View view) {
        return new StateViewBuilder(view);
    }

    public static StateView createWithBuilder(StateViewBuilder stateViewBuilder) {
        StateView stateView;
        switch (stateViewBuilder.enterType) {
            case StateViewConfig.STATE_VIEW_BUILDER_ACTIVITY_TYPE:
                stateView = wrap(stateViewBuilder.activity);
                break;
            case StateViewConfig.STATE_VIEW_BUILDER_FRAGMENT_TYPE:
                stateView = wrap(stateViewBuilder.fragment);
                break;
            default:
                stateView = wrap(stateViewBuilder.view);
                break;
        }
        stateView.emptyResId = stateViewBuilder.stateViewEmptyResId;
        stateView.loadingResId = stateViewBuilder.stateViewLoadingResId;
        stateView.netWorkErrorResId = stateViewBuilder.stateViewNetWorkErrorResId;
        stateView.errorResId = stateViewBuilder.stateViewErrorResId;
        stateView.stateViewReloadListener = stateViewBuilder.stateViewReloadListener;
        return stateView;
    }

    public static StateView wrap(Activity activity) {
        return wrap(((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0));
    }

    public static StateView wrap(Fragment fragment) {
        return wrap(fragment.getView());
    }

    public static StateView wrap(View view) {
        if (view == null) {
            throw new NullPointerException("content view can not be null");
        }
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent == null) {
            throw new NullPointerException("parent view can not be null");
        }
        //获取需要配置view的配置
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        int index = parent.indexOfChild(view);
        parent.removeView(view);

        //初始化自定义view
        StateView stateView = new StateView(view.getContext());
        stateView.addView(view);
        stateView.addContentViewToMap(view);

        parent.addView(stateView, index, lp);

        return stateView;
    }

    private void addContentViewToMap(View view) {
        mResIdMap.put(StateViewConfig.CONTENT_RES_ID, view);
    }

    public final void showLoading() {
        if (loadingResId == 0) {
            loadingResId = StateViewConfig.CONFIG.loadingResId;
        }
        show(loadingResId);
    }

    public final void showEmpty() {
        if (emptyResId == 0) {
            emptyResId = StateViewConfig.CONFIG.emptyResId;
        }
        show(emptyResId);
    }

    public final void showError() {
        if (errorResId == 0) {
            errorResId = StateViewConfig.CONFIG.errorResId;
        }
        show(errorResId);
    }

    public final void showNerWorkError() {
        if (netWorkErrorResId == 0) {
            netWorkErrorResId = StateViewConfig.CONFIG.netWorkErrorResId;
        }
        show(netWorkErrorResId);
    }

    public final void showContent() {
        show(StateViewConfig.CONTENT_RES_ID);
    }

    private void show(int resId) {
        for (View view : mResIdMap.values()) {
            view.setVisibility(GONE);
        }
        getView(resId).setVisibility(VISIBLE);
    }

    private View getView(int resId) {
        if (mResIdMap.containsKey(resId)) {
            return mResIdMap.get(resId);
        }
        View view = mInflater.inflate(resId, this, false);
        view.setVisibility(GONE);
        addView(view);
        mResIdMap.put(resId, view);

        if (resId == errorResId || resId == netWorkErrorResId) {
            View reloadView = view.findViewById(R.id.reload);
            if (reloadView != null) {
                reloadView.setOnClickListener(this);
            } else {
                view.setOnClickListener(this);
            }
        }
        return view;
    }

    public StateView setStateViewReloadListener(StateViewReloadListener stateViewReloadListener) {
        this.stateViewReloadListener = stateViewReloadListener;
        return this;
    }

    @Override
    public void onClick(View v) {
        if (stateViewReloadListener != null) {
            stateViewReloadListener.onStateViewReloadClicked();
        }
        showLoading();
    }

    public interface StateViewReloadListener {
        void onStateViewReloadClicked();
    }
}
