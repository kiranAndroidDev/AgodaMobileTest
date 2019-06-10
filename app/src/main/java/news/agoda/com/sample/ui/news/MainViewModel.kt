package news.agoda.com.sample.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.network.ApiClient
import okhttp3.ResponseBody
import javax.inject.Inject

/**
Created by kiranb on 7/6/19
 */
class MainViewModel @Inject constructor(var apiClient: ApiClient) : ViewModel() {
    private var items: MutableLiveData<List<NewsEntity>> = MutableLiveData()
    private var errorMessage =MutableLiveData<String>()

    fun fetchNewsList() {
        viewModelScope.launch {
            callNewsListApi()
        }

    }

    fun getItems() = items
    fun getError() = errorMessage

    private suspend fun callNewsListApi() = withContext(Dispatchers.Default) {
        val result = apiClient.newsList.await()
        if(result!=null && result.status == "ok")
            onSuccess(result.results)
        else
            onError()
    }


    private fun onSuccess(newsList: List<NewsEntity>?) {
        items.postValue(newsList)
    }

    private fun onError() {
            this.errorMessage.postValue("Something went wrong")
       }


}