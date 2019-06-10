package news.agoda.com.sample.network

import kotlinx.coroutines.Deferred
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.model.NewsList
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.GET
import java.util.ArrayList

/**
Created by kiranb on 7/6/19
 */
interface ApiClient {

    @get:GET(ApiConstants.NEWS_URL)
    val newsList: Deferred<Response<NewsList>>
}