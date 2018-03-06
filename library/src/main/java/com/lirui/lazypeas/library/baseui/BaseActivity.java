package com.lirui.lazypeas.library.baseui;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.debug.hv.ViewServer;

/**
 * Created by lirui on 2018/3/2.
 */

public abstract class BaseActivity extends AppCompatActivity implements UICallBack {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            ViewServer.get(this).addWindow(this);
        }
        initData(savedInstanceState);
        initView();
    }

    public void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }

    public void onResume() {
        super.onResume();
        ViewServer.get(this).setFocusedWindow(this);
    }
}
