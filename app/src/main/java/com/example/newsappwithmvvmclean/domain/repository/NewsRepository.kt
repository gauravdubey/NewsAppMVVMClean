package com.example.newsappwithmvvmclean.domain.repository

import com.example.newsappwithmvvmclean.data.model.APIResponse
import com.example.newsappwithmvvmclean.data.model.Article
import com.example.newsappwithmvvmclean.data.utils.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadlines(country: String, page: Int): Resource<APIResponse>
    suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Resource<APIResponse>

    suspend fun saveNews(article: Article)
    suspend fun deletesNews(article: Article)
    suspend fun getSavedNews(): Flow<List<Article>>
}