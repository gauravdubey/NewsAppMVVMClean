package com.example.newsappwithmvvmclean.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.newsappwithmvvmclean.data.model.APIResponse
import com.example.newsappwithmvvmclean.data.model.Article
import com.example.newsappwithmvvmclean.data.utils.Resource
import com.example.newsappwithmvvmclean.domain.usecase.DeleteSavedNewsUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetSavedUseCase
import com.example.newsappwithmvvmclean.domain.usecase.GetSearchedNewsUseCase
import com.example.newsappwithmvvmclean.domain.usecase.SaveNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUserCase: SaveNewsUseCase,
    private val getSavedNewsUse: GetSavedUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
) : AndroidViewModel(app) {
    val newsHeadlines: MutableLiveData<Resource<APIResponse>> = MutableLiveData()


    /**
     * Get the News Headlines from Remote
     */
    fun getNewsHeadlines(country: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        newsHeadlines.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val apiResult = getNewsHeadlinesUseCase.execute(country, page)
                newsHeadlines.postValue(apiResult)
            } else {
                newsHeadlines.postValue(Resource.Error("Internet is not available"))
            }
        } catch (exception: Exception) {
            newsHeadlines.postValue(Resource.Error(exception.message.toString()))
        }
    }

    /**
     * Search News from Remote
     */
    val searchNews:MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun searchNewsFromRemote(
        country: String,
        searchQuery: String,
        page: Int
    ) = viewModelScope.launch {
        searchNews.postValue(Resource.Loading())
        try {
            if (isNetworkAvailable(app)) {
                val  searchResult = getSearchedNewsUseCase.execute(country,searchQuery,page)
                searchNews.postValue(searchResult)
            }else{
                searchNews.postValue(Resource.Error("Internet is not available"))
            }
        }catch (ex:Exception){
            searchNews.postValue(Resource.Error(ex.message.toString()))
        }
    }

    /**
     * Save news locally
     */
    fun saveNewsArticle(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        saveNewsUserCase.execute(article)
    }

    /**
     * delete the local save news
     */
    fun deleteNews(article: Article) = viewModelScope.launch(Dispatchers.IO) {
        deleteSavedNewsUseCase.execute(article)
    }

    /**
     * get the saved news from local
     */
    fun getSavedNews()= liveData {
        getSavedNewsUse.execute().collect{
            emit(it)
        }
    }


    /**
     * To check the network state
     */
    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }

                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }

                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false

    }


}