package com.lirui.lazypeas;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.lirui.lazypeas.library.baseui.BaseActivity;

/**
 * Created by lirui on 2018/3/2.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content);

        Log.d("sdsdsd", ""+viewGroup.getChildAt(0).getId());
        Log.d("sdsdsd", ""+getLayoutId());
    }

    @Override
    public void onClick(View v) {

    }
}
