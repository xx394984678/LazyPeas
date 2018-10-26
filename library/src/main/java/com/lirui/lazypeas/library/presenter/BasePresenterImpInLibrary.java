package com.lirui.lazypeas.library.presenter;

import com.lirui.lazypeas.library.baseui.BaseView;
import com.lirui.lazypeas.library.model.BaseModel;
import com.lirui.lazypeas.library.model.BaseModelCallBack;

public abstract class BasePresenterImpInLibrary<V extends BaseView, M extends BaseModel> implements BasePresenter, BaseModelCallBack {
    protected V view;
    protected M model;

    public BasePresenterImpInLibrary(V view) {
        this.view = view;
        initModel();
    }

    protected abstract void initModel();

    public void unBindView() {
        view = null;
        model.onCancelRequest();
    }

    @Override
    public void onPageDataRequestFailure(int errorCode) {
        view.onPageDataRequestFailure();
        onRequestFailure(errorCode);
    }

    @Override
    public void onRequestFailure() {

    }
}
