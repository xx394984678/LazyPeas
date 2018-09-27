package com.lirui.lazypeas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.lirui.lazypeas.http.HttpUtilI;
import com.lirui.lazypeas.library.baseui.BaseActivity;
import com.lirui.lazypeas.library.util.LogUtilInLibrary;
import com.lirui.lazypeas.library.view.statusview.StatusView;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lirui on 2018/3/2.
 */

public class MainActivity extends BaseActivity implements StatusView.StateViewReloadListener{


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
                .setEmptyResId(R.layout.my_empty_layout)
                .setErrorResId(R.layout.my_empty_layout)
                .setLoadingResId(R.layout.my_empty_layout)
                .setNetWorkErrorResId(R.layout.my_empty_layout)
                .setStateViewReloadListener(new StatusView.StateViewReloadListener() {
                    @Override
                    public void onStateViewReloadClicked() {
                        Toast.makeText(MainActivity.this, "在这个方法中写网络请求", Toast.LENGTH_SHORT).show();
                    }
                });

        findViewById(R.id.sdsdsd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        HttpUtilI.getInstance().getTest().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    LogUtilInLibrary.dWithDefaultTag(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
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

    @Override
    public void onStateViewReloadClicked() {
        Toast.makeText(this, "在这个方法中写网络请求", Toast.LENGTH_SHORT).show();
    }

}
