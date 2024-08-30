package com.example.newsappwithmvvmclean.domain.usecase

import com.example.newsappwithmvvmclean.data.model.APIResponse
import com.example.newsappwithmvvmclean.data.utils.Resource
import com.example.newsappwithmvvmclean.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}