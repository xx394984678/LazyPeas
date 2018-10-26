package com.lirui.lazypeas.contract;

import com.lirui.lazypeas.library.baseui.BaseView;
import com.lirui.lazypeas.library.model.BaseModel;
import com.lirui.lazypeas.library.presenter.BasePresenter;
import com.lirui.lazypeas.model.MainModel;

public interface MainContract {
    interface Model extends BaseModel {
        void onGetHomePage(MainModel.OnGetHomePageDataListener listener);

        void onGetFailureData(int errorCodeYouWant, MainModel.OnGetHomePageDataListener listener);
    }

    interface View extends BaseView {
        void onGetPageDateSuccess(String json);
    }

    interface Presenter extends BasePresenter{
        void onGetHomePage();

        void getFailureData(int errorCode);
    }
}
