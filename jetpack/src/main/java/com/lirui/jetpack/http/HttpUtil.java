package com.lirui.jetpack.http;

import com.lirui.lazypeas.library.http.HttpUtilConfig;
import com.lirui.lazypeas.library.http.RetrofitUtil;

public class HttpUtil {

    public static HttpApi getInstance() {
        return RetrofitUtil.getInstance(HttpApi.class);
    }

    //设置连接类型。测试 beta 线上环境
    public static void setConnectType(@HttpUtilConfig.ConnectType int connectType) {
        HttpUtilConfig.CONFIG.setConnectType(connectType);
    }


}
