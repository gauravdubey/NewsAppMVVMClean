package com.example.newsappwithmvvmclean.presentation.di

import com.example.newsappwithmvvmclean.data.db.ArticleDao
import com.example.newsappwithmvvmclean.data.repository.dataSource.NewsLocalDataSource
import com.example.newsappwithmvvmclean.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {

    @Singleton
    @Provides
    fun provideLocalDataSource(articleDao: ArticleDao): NewsLocalDataSource {
        return NewsLocalDataSourceImpl(articleDao)
    }
}