package com.lirui.lazypeas.activity;

import com.lirui.lazypeas.library.baseui.BaseActivityInLibrary;
import com.lirui.lazypeas.library.baseui.BaseView;
import com.lirui.lazypeas.library.util.ToastUtil;

public abstract class BaseActivity extends BaseActivityInLibrary implements BaseView{

    @Override
    public void onVipDateOver() {
        ToastUtil.showToast("会员到期");
    }

    @Override
    public void onVipInvalid() {
        ToastUtil.showToast("会员无效");
    }

    @Override
    public void onConnectError() {
        ToastUtil.showToast("连接失败");
    }

    @Override
    public void onPageDataRequestFailure() {
        showError();
    }
}
