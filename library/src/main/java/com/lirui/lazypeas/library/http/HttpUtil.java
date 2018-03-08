package com.lirui.lazypeas.library.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by lirui on 2018/3/7.
 */

public final class HttpUtil {
    public static final HttpUtil instance = new HttpUtil();

    private HttpApi api;
    private final String baseUrl = "unknown";

    private HttpUtil() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(10000, TimeUnit.MILLISECONDS)
                .connectTimeout(10000, TimeUnit.MILLISECONDS);

        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build();
        api = retrofit.create(HttpApi.class);
    }

    public static HttpApi getInstance() {
        return instance.api;
    }
}
