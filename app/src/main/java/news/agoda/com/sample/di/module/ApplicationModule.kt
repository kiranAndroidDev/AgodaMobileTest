package news.agoda.com.sample.di.module

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
Created by kiranb on 7/6/19
 */

@Module(includes = arrayOf(ViewModelModule::class))
abstract class ApplicationModule {

    @Binds
    internal abstract fun provideContext(application: Application): Context

}