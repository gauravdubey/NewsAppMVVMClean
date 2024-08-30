package com.example.newsappwithmvvmclean.data.repository.dataSourceImpl

import com.example.newsappwithmvvmclean.data.api.NewsAPIService
import com.example.newsappwithmvvmclean.data.model.APIResponse
import com.example.newsappwithmvvmclean.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(private val newsAPIService: NewsAPIService) : NewsRemoteDataSource {

    override suspend fun getNewsHeadlines(
        country: String,
        page: Int
    )
    : Response<APIResponse> {
        return newsAPIService.getNewsHeadline(country, page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getSearchedNews(country, searchQuery, page)
    }
}