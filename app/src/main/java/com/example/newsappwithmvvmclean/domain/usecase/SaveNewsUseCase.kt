package com.example.newsappwithmvvmclean.domain.usecase

import com.example.newsappwithmvvmclean.data.model.Article
import com.example.newsappwithmvvmclean.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article)= newsRepository.saveNews(article)
}