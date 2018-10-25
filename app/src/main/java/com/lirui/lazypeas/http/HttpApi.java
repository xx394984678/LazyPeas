package com.lirui.lazypeas.http;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface HttpApi {
    @GET("banner/json")
    Call<ResponseBody> getTest();
}
