package com.lirui.lazypeas.http;

import com.lirui.lazypeas.library.http.RetrofitUtil;

public class HttpUtilI {
    public static HttpApiI getInstance() {
        return RetrofitUtil.getInstance(HttpApiI.class);
    }
}
