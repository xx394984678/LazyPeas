package com.lirui.lazypeas.library.baseui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lirui on 2018/3/2.
 */

public abstract class BaseActivity extends AppCompatActivity implements UICallBack {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.newActivity(this);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        initData(savedInstanceState);
        initView();
    }

    @Override
    protected void onDestroy() {
        ActivityManager.removeActivity(this);
        super.onDestroy();
    }

    protected void finishAll(){
        ActivityManager.allFinishActivity();
    }
}
