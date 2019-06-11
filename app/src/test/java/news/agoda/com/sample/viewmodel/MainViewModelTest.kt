package news.agoda.com.sample.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.model.NewsList
import news.agoda.com.sample.network.ApiClient
import news.agoda.com.sample.ui.news.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import retrofit2.Response

/**
Created by kiranb on 10/6/19
 */
@RunWith(JUnit4::class)
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    var apiClient:ApiClient?=null

    lateinit var mainViewModel: MainViewModel

    @Mock
    var observer: Observer<NewsList>? = null

   /* @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()*/

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        mainViewModel = MainViewModel(apiClient!!)
        mainViewModel.getItems().observeForever { observer};
    }

    @Test
    fun getNewsList(){
        Mockito.`when`(apiClient!!.newsList).thenReturn(GlobalScope.async {NewsList("ok",null,null,null) })
    }
}