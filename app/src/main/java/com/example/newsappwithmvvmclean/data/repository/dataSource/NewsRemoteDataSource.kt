package com.example.newsappwithmvvmclean.data.repository.dataSource

import com.example.newsappwithmvvmclean.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getNewsHeadlines(country:String,page:Int): Response<APIResponse>
    suspend fun getSearchedNews(country:String,searchQuery:String,page:Int): Response<APIResponse>
}