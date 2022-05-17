package com.example.tv_show.network


import com.example.tv_show.network.details.TvDetailsResponse
import com.example.tv_show.network.response.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvApiService {

    @GET("tv/popular?")
    fun getPopularTv(
        @Query("api_key") apiKey: String
    ) : Call<TvResponse>

    @GET("tv/on_the_air?")
    fun getTvOnTheAir(
        @Query("api_key") apiKey: String
    ) : Call<TvResponse>

    @GET("tv/airing_today?")
    fun getTvAiringTodays(
        @Query("api_key") apiKey: String
    ) : Call<TvResponse>

    @GET("tv/{tv_id}?")
    fun getTvDetailsById(
        @Path("tvId") tvId: String,
        @Query("api_key") apiKey: String
    ) : Call<TvDetailsResponse>
}