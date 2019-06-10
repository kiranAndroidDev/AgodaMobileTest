package news.agoda.com.sample.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.AndroidInjection

/**
Created by kiranb on 7/6/19
 */
abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {

    protected var binding: B? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        super.onCreate(savedInstanceState)
    }

    abstract fun getLayoutId(): Int

}