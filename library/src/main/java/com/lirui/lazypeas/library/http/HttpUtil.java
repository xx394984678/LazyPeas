package com.lirui.lazypeas.library.http;

import com.lirui.lazypeas.library.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by lirui on 2018/3/7.
 */
public final class HttpUtil<T> {
    private static final int DEBUG_CONNECT_TYPE = 1;
    private static final int ON_LINE_CONNECT_TYPE = 2;
    //连接类型，默认为debug方式
    private static int connectType = DEBUG_CONNECT_TYPE;

    private static volatile HttpUtil onLineInstance;
    private static volatile HttpUtil debugInstance;

    private T api;

    private HttpUtil(String baseUrl, Class<T> clz) {
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

    /**
     * 设置api的网络环境。可以动态切换线上环境与debug环境。仅限debug包
     * @param connectType {@link #DEBUG_CONNECT_TYPE}代表测试环境
     *                    {@link #ON_LINE_CONNECT_TYPE}代表线上环境
     *
     */
    public void setConnectType(int connectType) {
        HttpUtil.connectType = connectType;
    }

    public static <T> T getInstance(Class<T> clz) {
        //如果是release包。须直接返回线上环境的httpApi
        if (!BuildConfig.DEBUG) {
            return getOnLineInstance(clz);
        }
        //debug包。根据链接类型来定
        switch (connectType) {
            case DEBUG_CONNECT_TYPE:
                return getDebugInstance(clz);
            case ON_LINE_CONNECT_TYPE:
            default:
                return getOnLineInstance(clz);
        }
    }

    private static <T> T getDebugInstance(Class<T> clz) {
        if (debugInstance == null) {
            synchronized (HttpUtil.class) {
                if (debugInstance == null) {
                    debugInstance = new HttpUtil<>(HttpUtilConfig.CONFIG.baseDebugUrl,clz);
                }
            }
        }
        return (T) debugInstance.api;
    }

    private static <T> T getOnLineInstance(Class<T> clz) {
        if (onLineInstance == null) {
            synchronized (HttpUtil.class) {
                if (onLineInstance == null) {
                    onLineInstance = new HttpUtil<>(HttpUtilConfig.CONFIG.baseOnLineUrl,clz);
                }
            }
        }
        return (T) onLineInstance.api;
    }
}
