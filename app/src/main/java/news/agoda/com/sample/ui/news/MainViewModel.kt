package news.agoda.com.sample.ui.news

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.model.NewsList
import news.agoda.com.sample.network.ApiClient
import javax.inject.Inject

/**
Created by kiranb on 7/6/19
 */
class MainViewModel @Inject constructor(var apiClient: ApiClient) : ViewModel() {
    private var items: MutableLiveData<List<NewsEntity>> = MutableLiveData()

    fun fetchNewsList() {
        onLoading()
        viewModelScope.launch {
            callNewsListApi()
        }

    }

    fun getItems() = items


    private suspend fun callNewsListApi() = withContext(Dispatchers.Default) {
        val result = apiClient.newsList.await()
        onSuccess(result.results)
    }


    private fun onSuccess(newsList: List<NewsEntity>?) {
        items.postValue(newsList)
    }

    private fun onError(error: Throwable?) {

       }

    private fun onLoading() {

    }

}