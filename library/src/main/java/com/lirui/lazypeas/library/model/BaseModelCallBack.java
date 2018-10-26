package com.lirui.lazypeas.library.model;

public interface BaseModelCallBack {
    void onPageDataRequestFailure(int errorCode);

    void onRequestFailure(int errorCode);

    void onRequestFailure();
}
