package com.example.newsappwithmvvmclean.presentation.di

import android.app.Application
import com.example.newsappwithmvvmclean.domain.usecase.DeleteSavedNewsUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetSavedUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetSearchedNewsUseCase
import com.example.newsappwithmvvmclean.domain.usecase.SaveNewsUseCase
import com.example.newsappwithmvvmclean.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: GetSearchedNewsUseCase,
        saveNewsUseCase: SaveNewsUseCase,
        getSaveNewsUseCase: GetSavedUseCase,
        deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ):NewsViewModelFactory{
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSaveNewsUseCase,
            deleteSavedNewsUseCase
        )
    }
}