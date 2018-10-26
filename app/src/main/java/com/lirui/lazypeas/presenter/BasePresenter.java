package com.lirui.lazypeas.presenter;

import com.lirui.lazypeas.activity.NetWorkErrorCode;
import com.lirui.lazypeas.library.baseui.BaseView;
import com.lirui.lazypeas.library.model.BaseModel;
import com.lirui.lazypeas.library.presenter.BasePresenterImpInLibrary;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> extends BasePresenterImpInLibrary<V, M> {
    public BasePresenter(V view) {
        super(view);
    }

    @Override
    public void onRequestFailure(int errorCode) {
        switch (errorCode) {
            case NetWorkErrorCode.VIP_OVER:
                view.onVipDateOver();
                break;
            case NetWorkErrorCode.USER_IS_INVALID:
                view.onVipInvalid();
                break;
            case NetWorkErrorCode.CONNECT_FAILURE:
                view.onConnectError();
                break;
        }
    }
}
