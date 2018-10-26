package com.lirui.lazypeas.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.lirui.lazypeas.R;
import com.lirui.lazypeas.library.baseui.BaseActivity;
import com.lirui.lazypeas.library.view.statusview.StatusView;

/**
 * Created by lirui on 2018/3/2.
 */

public class MainActivity extends BaseActivity implements StatusView.StateViewReloadListener {


    StatusView statusView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        statusView = StatusView.wrap(this)
                .setStateViewReloadListener(this);

        findViewById(R.id.first).setOnClickListener(this);
        findViewById(R.id.second).setOnClickListener(this);
        findViewById(R.id.third).setOnClickListener(this);
        findViewById(R.id.fourth).setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_empty:
                statusView.showEmpty();
                return true;
            case R.id.action_loading:
                statusView.showLoading();
                return true;
            case R.id.action_content:
                statusView.showContent();
                return true;
            case R.id.action_error:
                statusView.showError();
                return true;
            case R.id.action_network_error:
                statusView.showNetWorkError();
                return true;
            case android.R.id.home:
                finish();
                return true;
        }
        return false;
    }

    @Override
    public void onStateViewReloadClicked() {
        Toast.makeText(this, "在这个方法中写网络请求", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first:
                break;
            case R.id.second:
                break;
            case R.id.third:
                break;
            case R.id.fourth:
                break;
            default:
                break;
        }
    }
}
