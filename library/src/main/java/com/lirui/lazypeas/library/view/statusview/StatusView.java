package com.lirui.lazypeas.library.view.statusview;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.lirui.lazypeas.library.R;

/**
 * Created by lirui on 2018/3/2.
 */

public class StatusView extends FrameLayout implements View.OnClickListener, StatusViewControl {
    private LayoutInflater mInflater;
    private SparseArray<View> mResIdMap = new SparseArray<>();

    private int errorResId = 0;
    private int emptyResId = 0;
    private int loadingResId = 0;
    private int netWorkErrorResId = 0;
    private StatusViewReloadClickListener stateViewReloadListener;

    public StatusView(@NonNull Context context) {
        this(context, null);
    }

    public StatusView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StatusView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
    }

    public static StatusView wrap(Activity activity) {
        return wrap(((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0));
    }

    public static StatusView wrap(Fragment fragment) {
        return wrap(fragment.getView());
    }

    public static StatusView wrap(View view) {
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
        StatusView stateView = new StatusView(view.getContext());
        stateView.addView(view);
        stateView.addContentViewToMap(view);

        parent.addView(stateView, index, lp);

        return stateView;
    }

    private void addContentViewToMap(View view) {
        mResIdMap.put(StatusViewConfig.CONTENT_RES_ID, view);
    }

    public StatusView setErrorResId(int errorResId) {
        this.errorResId = errorResId;
        return this;
    }

    public StatusView setEmptyResId(int emptyResId) {
        this.emptyResId = emptyResId;
        return this;
    }

    public StatusView setLoadingResId(int loadingResId) {
        this.loadingResId = loadingResId;
        return this;
    }

    public StatusView setNetWorkErrorResId(int netWorkErrorResId) {
        this.netWorkErrorResId = netWorkErrorResId;
        return this;
    }

    @Override
    public final void showLoading() {
        if (loadingResId == 0) {
            loadingResId = StatusViewConfig.CONFIG.loadingResId;
        }
        show(loadingResId);
    }

    @Override
    public final void showEmpty() {
        if (emptyResId == 0) {
            emptyResId = StatusViewConfig.CONFIG.emptyResId;
        }
        show(emptyResId);
    }

    @Override
    public final void showError() {
        if (errorResId == 0) {
            errorResId = StatusViewConfig.CONFIG.errorResId;
        }
        show(errorResId);
    }

    @Override
    public final void showNetWorkError() {
        if (netWorkErrorResId == 0) {
            netWorkErrorResId = StatusViewConfig.CONFIG.netWorkErrorResId;
        }
        show(netWorkErrorResId);
    }

    @Override
    public final void showContent() {
        show(StatusViewConfig.CONTENT_RES_ID);
    }

    private void show(int resId) {
        for (int i = 0; i < mResIdMap.size(); i++) {
            View view = mResIdMap.valueAt(i);
            view.setVisibility(GONE);
        }
        getView(resId).setVisibility(VISIBLE);
    }

    private View getView(int resId) {
        if (mResIdMap.get(resId) != null) {
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

    public StatusView setStateViewReloadListener(StatusViewReloadClickListener stateViewReloadListener) {
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
}
