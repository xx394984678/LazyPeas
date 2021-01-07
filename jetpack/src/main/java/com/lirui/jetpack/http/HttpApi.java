package com.lirui.jetpack.http;

import com.lirui.jetpack.http.entity.Movies;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HttpApi {
    @GET("movie/in_theathers")
    Call<Movies> getMovies(@Query("start") int since, @Query("count") int perPage);
}
