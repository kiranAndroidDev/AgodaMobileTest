package news.agoda.com.sample.base

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import dagger.android.AndroidInjection
import news.agoda.com.sample.util.ConnectivityReceiver

/**
Created by kiranb on 7/6/19
 */
abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity(), ConnectivityReceiver.ConnectivityReceiverListener {
    override fun onNetworkConnectionChanged(isConnected: Boolean) {
        if(!isConnected)
        Toast.makeText(this,"Internet Connection Missing",Toast.LENGTH_LONG).show()
    }

    protected var binding: B? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        super.onCreate(savedInstanceState)
        registerReceiver(ConnectivityReceiver(),
                IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onResume() {
        super.onResume()
        ConnectivityReceiver.connectivityReceiverListener = this
    }



    abstract fun getLayoutId(): Int

}