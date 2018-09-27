package com.lirui.lazypeas.library.http;

import com.lirui.lazypeas.library.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by lirui on 2018/3/7.
 */
public final class RetrofitUtil<T> {
    private static volatile RetrofitUtil onLineInstance;
    private static volatile RetrofitUtil debugInstance;

    private T api;

    private RetrofitUtil(String baseUrl, Class<T> clz) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(HttpUtilConfig.CONFIG.readTimeOut, TimeUnit.MILLISECONDS)
                .connectTimeout(HttpUtilConfig.CONFIG.connectTimeOut, TimeUnit.MILLISECONDS);

        OkHttpClient okHttpClient = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .build();
        api = retrofit.create(clz);
    }

    public static <T> T getInstance(Class<T> clz) {
        //如果是release包。须直接返回线上环境的httpApi
        if (!BuildConfig.DEBUG) {
            return getOnLineInstance(clz);
        }
        //debug包。根据链接类型来定
        switch (HttpUtilConfig.CONFIG.connectType) {
            case HttpUtilConfig.DEBUG_CONNECT_TYPE:
                return getDebugInstance(clz);
            case HttpUtilConfig.ON_LINE_CONNECT_TYPE:
            default:
                return getOnLineInstance(clz);
        }
    }

    private static <T> T getDebugInstance(Class<T> clz) {
        if (debugInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (debugInstance == null) {
                    debugInstance = new RetrofitUtil<>(HttpUtilConfig.CONFIG.baseDebugUrl,clz);
                }
            }
        }
        return (T) debugInstance.api;
    }

    private static <T> T getOnLineInstance(Class<T> clz) {
        if (onLineInstance == null) {
            synchronized (RetrofitUtil.class) {
                if (onLineInstance == null) {
                    onLineInstance = new RetrofitUtil<>(HttpUtilConfig.CONFIG.baseOnLineUrl,clz);
                }
            }
        }
        return (T) onLineInstance.api;
    }
}
