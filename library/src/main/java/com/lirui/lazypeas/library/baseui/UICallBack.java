package com.lirui.lazypeas.library.baseui;

import android.os.Bundle;

/**
 * Created by lirui on 2018/3/2.
 * 一个activity 基本上包括的内容
 */

public interface UICallBack {
    //返回布局文件id
    int getLayoutId();

    //初始化数据 一些暂存的东西
    void initData(Bundle savedInstanceState);

    //初始化view
    void initView();

    //初始化其他的 比如adapter  presenter等等
    void initOther();

    //开始网络请求，仅限于请求当前页面相关的接口。用于请求失败，更改页面状态
    void netWorkForPageDate();
}
