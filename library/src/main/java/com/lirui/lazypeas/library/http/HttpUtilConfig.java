package com.lirui.lazypeas.library.http;

import android.support.annotation.IntDef;

public class HttpUtilConfig {

    public static final HttpUtilConfig CONFIG = new HttpUtilConfig();

    public static final int DEBUG_CONNECT_TYPE = 1;
    public static final int BETA_CONNECT_TYPE = 2;
    public static final int ON_LINE_CONNECT_TYPE = 3;
    //连接类型，默认为debug方式
    protected int connectType = DEBUG_CONNECT_TYPE;
    protected String baseDebugUrl;
    protected String baseOnLineUrl;
    protected int readTimeOut = 10000;
    protected int connectTimeOut = 10000;

    @IntDef({DEBUG_CONNECT_TYPE, BETA_CONNECT_TYPE, ON_LINE_CONNECT_TYPE})
    public @interface ConnectType { }

    private HttpUtilConfig() {
    }

    /**
     * 设置api的网络环境。可以动态切换线上环境与debug环境。仅限debug包
     * 设置后，下次请求，会在{@link RetrofitUtil#getInstance(Class)}的case中进行判断
     * @param connectType {@link #DEBUG_CONNECT_TYPE}代表测试环境
     *                    {@link #ON_LINE_CONNECT_TYPE}代表线上环境
     *
     */
    public void setConnectType(int connectType) {
        this.connectType = connectType;
    }

    public HttpUtilConfig setBaseDebugUrl(String baseDebugUrl) {
        this.baseDebugUrl = baseDebugUrl;
        return this;
    }

    public HttpUtilConfig setBaseOnLineUrl(String BASE_ON_LINE_URL) {
        this.baseOnLineUrl = BASE_ON_LINE_URL;
        return this;
    }

    public HttpUtilConfig setReadTimeOut(int readTimeOut) {
        this.readTimeOut = readTimeOut;
        return this;
    }

    public HttpUtilConfig setConnectTimeOut(int connectTimeOut) {
        this.connectTimeOut = connectTimeOut;
        return this;
    }
}
