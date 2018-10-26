package com.lirui.lazypeas.library.view.statusview;

public interface StatusViewControl {
    void showLoading();
    void showEmpty();
    void showError();
    void showNetWorkError();
    void showContent();
}
