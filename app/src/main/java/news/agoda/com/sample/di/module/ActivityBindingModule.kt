package news.agoda.com.sample.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import news.agoda.com.sample.ui.details.DetailViewActivity
import news.agoda.com.sample.ui.news.MainActivity

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    internal abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun bindDetailActivity(): DetailViewActivity
}
