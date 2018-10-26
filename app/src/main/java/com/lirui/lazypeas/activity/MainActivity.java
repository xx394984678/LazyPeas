package com.lirui.lazypeas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.lirui.lazypeas.R;
import com.lirui.lazypeas.contract.MainContract;
import com.lirui.lazypeas.library.presenter.BasePresenter;
import com.lirui.lazypeas.library.view.statusview.StatusView;
import com.lirui.lazypeas.presenter.MainPresenterImp;

/**
 * Created by lirui on 2018/3/2.
 */

public class MainActivity extends BaseActivity implements MainContract.View {

    StatusView statusView;
    private TextView textView;
    private MainContract.Presenter pagePresenter;

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

        textView = findViewById(R.id.connect_result);
        findViewById(R.id.first).setOnClickListener(this);
        findViewById(R.id.second).setOnClickListener(this);
        findViewById(R.id.third).setOnClickListener(this);
        findViewById(R.id.fourth).setOnClickListener(this);
    }

    @Override
    public void initOther() {
        pagePresenter = new MainPresenterImp(this);
    }

    @Override
    public void netWorkForPageDate() {
        pagePresenter.onGetHomePage();
    }

    @Override
    public void onGetPageDateSuccess(String json) {
        showContent();
        textView.setText(json);
    }

    @Override
    protected boolean loadingAndGetPageDataOnCreate() {
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first:
                startActivity(new Intent(this, SecondActivity.class));
                break;
            case R.id.second:
                netWorkForPageDate();
                break;
            case R.id.third:
                pagePresenter.getFailureData(NetWorkErrorCode.VIP_OVER);
                break;
            case R.id.fourth:
                pagePresenter.getFailureData(NetWorkErrorCode.USER_IS_INVALID);
                break;
            default:
                break;
        }
    }

    @Override
    protected StatusView getStatusView() {
        return statusView;
    }

    @Override
    protected BasePresenter getPageDataPresenter() {
        return pagePresenter;
    }

    @Override
    protected void presenterUnBindView() {

    }
}
