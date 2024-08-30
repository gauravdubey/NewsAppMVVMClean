package com.example.newsappwithmvvmclean.domain.usecase

import com.example.newsappwithmvvmclean.data.model.Article
import com.example.newsappwithmvvmclean.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Flow<List<Article>> {
        return newsRepository.getSavedNews()
    }

}
