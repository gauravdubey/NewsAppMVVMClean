package com.example.newsappwithmvvmclean.presentation.di

import com.example.newsappwithmvvmclean.domain.repository.NewsRepository
import com.example.newsappwithmvvmclean.domain.usecase.DeleteSavedNewsUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetSavedUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetSearchedNewsUseCase
import com.example.newsappwithmvvmclean.domain.usecase.SaveNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsHeadlineUseCase(newsRepository: NewsRepository):GetNewsHeadlinesUseCase{
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedNewsUseCase(newsRepository: NewsRepository): GetSearchedNewsUseCase{
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideSaveNewsUseCase(newsRepository: NewsRepository): SaveNewsUseCase{
        return SaveNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteNewsUseCase(newsRepository: NewsRepository) : DeleteSavedNewsUseCase{
        return DeleteSavedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedNews(newsRepository: NewsRepository):GetSavedUseCase{
        return GetSavedUseCase(newsRepository)
    }
}