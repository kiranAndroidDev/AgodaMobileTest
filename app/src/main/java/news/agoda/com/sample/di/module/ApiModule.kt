package news.agoda.com.sample.di.module

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import news.agoda.com.sample.di.scope.AppScope
import news.agoda.com.sample.network.ApiClient
import news.agoda.com.sample.network.ApiConstants
import news.agoda.com.sample.util.MediaListTypeAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
Created by kiranb on 7/6/19
 */
@Module
class ApiModule {

    @AppScope
    @Provides
    internal fun provideRetrofit(): Retrofit {
        val gson = GsonBuilder().registerTypeAdapterFactory(MediaListTypeAdapter()).create()
        return Retrofit.Builder().baseUrl(ApiConstants.BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @AppScope
    @Provides
    internal fun provideNewsApi(retrofit: Retrofit): ApiClient {
        return retrofit.create(ApiClient::class.java)
    }
}