package news.agoda.com.sample.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
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
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import junit.framework.Assert.*
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After

/**
Created by kiranb on 10/6/19
 */
@RunWith(JUnit4::class)
class MainViewModelTest {

    @Mock
    var apiClient: ApiClient? = null

    lateinit var mainViewModel: MainViewModel


    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    val newsList = NewsList("OK")
    val threadContext = newSingleThreadContext("UI thread")
    val observerNews = mock(Observer::class.java) as Observer<NewsList>
    val observerError = mock(Observer::class.java) as Observer<String>

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(threadContext)
        mainViewModel = MainViewModel(apiClient!!)
    }

    @Test
    fun getNewsListSucces() {
        Mockito.`when`(apiClient!!.newsList).thenAnswer {
            return@thenAnswer GlobalScope.async { newsList }
        }
        mainViewModel.getItems().observeForever(observerNews)

        mainViewModel.fetchNewsList()
        Thread.sleep(1000)
        verify(observerNews).onChanged(newsList)
        assertNotNull(mainViewModel.getItems().value)
        assertEquals("OK", mainViewModel.getItems().value!!.status)
    }

    @Test
    fun getNewsListFailure() {
        Mockito.`when`(apiClient!!.newsList).thenAnswer {
            return@thenAnswer GlobalScope.async { null }
        }
        mainViewModel.getError().observeForever(observerError)

        mainViewModel.fetchNewsList()
        Thread.sleep(1000)
        verify(observerError).onChanged("Something went wrong")
        assertNotNull(mainViewModel.getError().value)
        assertNull(mainViewModel.getItems().value)
    }

    @Test
    fun callGetNewsApi(){
        runBlocking {
            apiClient!!.newsList
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        threadContext.close()
    }

}