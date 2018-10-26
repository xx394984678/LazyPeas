package com.lirui.lazypeas.presenter;

import com.lirui.lazypeas.contract.MainContract;
import com.lirui.lazypeas.model.MainModel;

public class MainPresenterImp extends BasePresenter<MainContract.View, MainContract.Model> implements MainContract.Presenter,
        MainModel.OnGetHomePageDataListener {
    public MainPresenterImp(MainContract.View view) {
        super(view);
    }

    @Override
    protected void initModel() {
        model = new MainModel();
    }

    @Override
    public void onGetHomePage() {
        model.onGetHomePage(this);
    }

    @Override
    public void getFailureData(int errorCode) {
        model.onGetFailureData(errorCode, this);
    }

    @Override
    public void onSuccess(String json) {
        view.onGetPageDateSuccess(json);
    }
}
