package com.example.newsappwithmvvmclean.domain.usecase

import com.example.newsappwithmvvmclean.data.model.Article
import com.example.newsappwithmvvmclean.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deletesNews(article)
}