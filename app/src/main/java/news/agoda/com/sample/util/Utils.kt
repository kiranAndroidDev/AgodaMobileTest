package news.agoda.com.sample.util

import android.content.Context
import android.net.ConnectivityManager



/**
Created by kiranb on 10/6/19
 */


fun isNetworkConnected(context: Context): Boolean {
    val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = cm.activeNetworkInfo
    return info != null && info.isConnected

}