package com.lirui.lazypeas.library.http;

public class HttpUtilConfig {

    public static final HttpUtilConfig CONFIG = new HttpUtilConfig();

    protected Class apiClass;
    protected String baseDebugUrl;
    protected String baseOnLineUrl;
    protected int readTimeOut = 10000;
    protected int connectTimeOut = 10000;

    private HttpUtilConfig() {
    }

    public HttpUtilConfig setApiClass(Class apiClass) {
        this.apiClass = apiClass;
        return this;
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
