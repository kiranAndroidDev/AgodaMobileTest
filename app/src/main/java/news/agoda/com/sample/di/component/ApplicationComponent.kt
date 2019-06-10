package news.agoda.com.sample.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import news.agoda.com.sample.NewsApp
import news.agoda.com.sample.di.module.ActivityBindingModule
import news.agoda.com.sample.di.module.ApiModule
import news.agoda.com.sample.di.module.ApplicationModule
import news.agoda.com.sample.di.scope.AppScope

/**
Created by kiranb on 7/6/19
 */
@AppScope
@Component(
        modules = arrayOf(
                AndroidSupportInjectionModule::class,ApplicationModule::class,
                ApiModule::class,ActivityBindingModule::class
        )
)
interface ApplicationComponent : AndroidInjector<NewsApp> {

    override fun inject(application: NewsApp)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: NewsApp): Builder

        fun build(): ApplicationComponent
    }
}