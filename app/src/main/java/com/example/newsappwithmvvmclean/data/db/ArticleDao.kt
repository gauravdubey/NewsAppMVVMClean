package com.example.newsappwithmvvmclean.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.newsappwithmvvmclean.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {
    @Insert
    suspend fun insert(article: Article)

    @Query("Select *from articles")
    fun getAllArticles():Flow<List<Article>>


    @Delete
    suspend fun deleteArticle(article: Article)
}