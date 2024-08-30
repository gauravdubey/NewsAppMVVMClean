package com.example.newsappwithmvvmclean.data.repository.dataSource

import com.example.newsappwithmvvmclean.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
    fun getSavedArticles(): Flow<List<Article>>
    suspend fun deleteArticleFromDB(article: Article)
}