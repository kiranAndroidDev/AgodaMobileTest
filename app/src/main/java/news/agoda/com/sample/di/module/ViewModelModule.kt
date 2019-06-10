package news.agoda.com.sample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import news.agoda.com.sample.di.scope.ViewModelKey
import news.agoda.com.sample.ui.news.MainViewModel
import news.agoda.com.sample.viewmodel.ViewModelFactory

/**
Created by kiranb on 7/6/19
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel


    @Binds
    internal abstract fun bindMyViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}