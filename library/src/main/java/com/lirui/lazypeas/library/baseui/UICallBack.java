package com.lirui.lazypeas.library.baseui;

import android.os.Bundle;

/**
 * Created by lirui on 2018/3/2.
 */

public interface UICallBack {
    //返回布局文件id
    int getLayoutId();

    //初始化数据
    void initData(Bundle savedInstanceState);

    //初始化布局文件
    void initView();
}
