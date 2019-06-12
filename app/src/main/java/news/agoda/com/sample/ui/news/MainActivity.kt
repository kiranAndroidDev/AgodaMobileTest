package news.agoda.com.sample.ui.news

import android.content.Intent
import android.graphics.drawable.GradientDrawable

import android.os.Bundle

import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import javax.inject.Inject

import news.agoda.com.sample.ui.details.DetailViewActivity
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.R
import news.agoda.com.sample.base.BaseActivity
import news.agoda.com.sample.databinding.ActivityMainBinding
import news.agoda.com.sample.util.isNetworkConnected
import news.agoda.com.sample.viewmodel.ViewModelFactory

class MainActivity : BaseActivity<ActivityMainBinding>(), NewsListAdapter.ItemClick<NewsEntity> {

    private var newsListAdapter: NewsListAdapter? = null
    private var newsViewModel: MainViewModel? = null

    @Inject
    lateinit var newsViewModelFactory: ViewModelFactory

    val layout: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        newsViewModel = ViewModelProviders.of(this, newsViewModelFactory).get(MainViewModel::class.java)
        initNewsDataAdapter()
        observeListChange()
        observeError()
        fetchList()
    }

    private fun fetchList() {
        binding!!.showLoading = true
        if(isNetworkConnected(this))
        newsViewModel!!.fetchNewsList()
        else {
            showToast("Internet Connection missing")
            checkInternetConnectionAgain();
        }
    }

    private fun checkInternetConnectionAgain() {
        CoroutineScope(Dispatchers.Main).launch{
            delay(3000)
            fetchList()
        }

    }

    private fun initNewsDataAdapter() {
        newsListAdapter = NewsListAdapter(this)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = newsListAdapter
        newsListAdapter!!.addListener(this)
    }


    private fun observeListChange() {
        newsViewModel!!.getItems().observe(this) {
                binding!!.showLoading = false
                newsListAdapter?.newsList = it.results

        }
    }

    private fun observeError() {
        newsViewModel!!.getError().observe(this) { if (it!=null) {
            binding!!.showLoading = false
            showToast("Something went wrong")
        }

        }
    }

   override fun onItemClick(newsEntity: NewsEntity) {
       val i = Intent(this, DetailViewActivity::class.java)
       i.putExtra("NewsItem",newsEntity)
       startActivity(i)
   }

    override fun onDestroy() {
        super.onDestroy()
        if (newsListAdapter != null) {
            newsListAdapter!!.removeListener()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}
