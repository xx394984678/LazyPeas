package com.lirui.lazypeas.model;

import com.lirui.lazypeas.contract.MainContract;
import com.lirui.lazypeas.http.HttpUtil;
import com.lirui.lazypeas.library.model.BaseModelCallBack;
import com.lirui.lazypeas.library.model.BaseModelImp;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainModel extends BaseModelImp implements MainContract.Model {
    @Override
    public void onGetHomePage(final OnGetHomePageDataListener listener) {
        HttpUtil.getInstance().getTest().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    listener.onSuccess(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.onPageDataRequestFailure(11);
            }
        });
    }

    @Override
    public void onGetFailureData(int errorCodeYouWant, OnGetHomePageDataListener listener) {
        listener.onPageDataRequestFailure(errorCodeYouWant);
    }

    public interface OnGetHomePageDataListener extends BaseModelCallBack {
        void onSuccess(String json);
    }

}
