package com.lirui.lazypeas.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.lirui.lazypeas.R;
import com.lirui.lazypeas.library.baseui.BaseActivity;
import com.lirui.lazypeas.library.view.statusview.StatusView;

/**
 * Created by lirui on 2018/3/6.
 */

public class SecondActivity extends BaseActivity {
    StatusView statusView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_second;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        statusView = StatusView.wrap(this).setEmptyResId(R.layout.my_empty_layout);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
