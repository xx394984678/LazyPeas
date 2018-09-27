package com.lirui.lazypeas.http;

import com.lirui.lazypeas.library.http.HttpUtil;

public class HttpUtilI {
    public static HttpApiI getInstance() {
        return HttpUtil.getInstance(HttpApiI.class);
    }
}
