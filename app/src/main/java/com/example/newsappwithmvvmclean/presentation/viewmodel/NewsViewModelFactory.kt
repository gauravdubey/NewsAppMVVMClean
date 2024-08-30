package com.example.newsappwithmvvmclean.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsappwithmvvmclean.domain.usecase.DeleteSavedNewsUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetSavedUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetSearchedNewsUseCase
import com.example.newsappwithmvvmclean.domain.usecase.SaveNewsUseCase

class NewsViewModelFactory(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val getSaveNewsUseCase: GetSavedUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSaveNewsUseCase,
            deleteSavedNewsUseCase
        ) as T
    }
}