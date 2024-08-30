package com.example.newsappwithmvvmclean.data.repository.dataSourceImpl

import com.example.newsappwithmvvmclean.data.db.ArticleDao
import com.example.newsappwithmvvmclean.data.model.Article
import com.example.newsappwithmvvmclean.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(private val articleDao: ArticleDao) : NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }

    override suspend fun deleteArticleFromDB(article: Article) {
        articleDao.deleteArticle(article)
    }
}