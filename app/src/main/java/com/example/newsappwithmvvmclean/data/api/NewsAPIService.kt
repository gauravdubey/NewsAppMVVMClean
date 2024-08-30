package com.example.newsappwithmvvmclean.data.api

import com.example.newsappwithmvvmclean.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPIService {

    @GET("v2/top-headlines")
    suspend fun getNewsHeadline(
        @Query("country") country: String,
        @Query("page") page: Int,
        @Query("apikey") apikey: String = "77af850922f8452497c842704f0f50bb"/*BuildConfig.API_KEY*/
    ): Response<APIResponse>
    @GET("v2/top-headlines")
    suspend fun getSearchedNews(
        @Query("country") country: String,
        @Query("q") searchQuery:String,
        @Query("page") page: Int,
        @Query("apikey") apikey: String = "77af850922f8452497c842704f0f50bb"/*BuildConfig.API_KEY*/
    ): Response<APIResponse>
}