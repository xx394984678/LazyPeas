package com.lirui.lazypeas.library.baseui;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lirui.lazypeas.library.view.statusview.StatusView;
import com.lirui.lazypeas.library.view.statusview.StatusViewControl;
import com.lirui.lazypeas.library.view.statusview.StatusViewReloadClickListener;

/**
 * Created by lirui on 2018/3/2.
 */

public abstract class BaseActivityInLibrary extends AppCompatActivity implements UICallBack, View.OnClickListener
        , StatusViewReloadClickListener, StatusViewControl {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.newActivity(this);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        initView();
        initOther();
        initData(savedInstanceState);
        if (loadingAndGetPageDataOnCreate()) {
            showLoading();
            netWorkForPageDate();
        }
    }

    @Override
    protected void onDestroy() {
        presenterUnBindView();
        ActivityManager.removeActivity(this);
        super.onDestroy();
    }

    /**
     * onCreate 的时候 得到一个标志位，是否要显示加载页面
     */
    protected abstract boolean loadingAndGetPageDataOnCreate();

    /**
     * finish all activity include mainActivity
     */
    protected void finishAll() {
        ActivityManager.allFinishActivity();
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onStateViewReloadClicked() {
        showLoading();
        netWorkForPageDate();
    }

    @Override
    public final void showLoading() {
        if (getStatusView() != null) {
            getStatusView().showLoading();
        }
    }

    @Override
    public final void showEmpty() {
        if (getStatusView() != null) {
            getStatusView().showEmpty();
        }
    }

    @Override
    public final void showError() {
        if (getStatusView() != null) {
            getStatusView().showError();
        }
    }

    @Override
    public final void showNetWorkError() {
        if (getStatusView() != null) {
            getStatusView().showNetWorkError();
        }
    }

    @Override
    public final void showContent() {
        if (getStatusView() != null) {
            getStatusView().showContent();
        }
    }

    protected abstract StatusView getStatusView();

    protected abstract void presenterUnBindView();
}
