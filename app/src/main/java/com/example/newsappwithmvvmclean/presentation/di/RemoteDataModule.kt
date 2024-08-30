package com.example.newsappwithmvvmclean.presentation.di

import com.example.newsappwithmvvmclean.data.api.NewsAPIService
import com.example.newsappwithmvvmclean.data.repository.dataSource.NewsRemoteDataSource
import com.example.newsappwithmvvmclean.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(apiService: NewsAPIService):NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(apiService)
    }
}