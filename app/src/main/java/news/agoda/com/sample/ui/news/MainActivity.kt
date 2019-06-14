package news.agoda.com.sample.ui.news

import android.content.Intent

import android.os.Bundle

import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*

import javax.inject.Inject

import news.agoda.com.sample.ui.details.DetailViewActivity
import news.agoda.com.sample.model.NewsEntity
import news.agoda.com.sample.R
import news.agoda.com.sample.base.BaseActivity
import news.agoda.com.sample.databinding.ActivityMainBinding
import news.agoda.com.sample.util.isNetworkConnected
import news.agoda.com.sample.viewmodel.ViewModelFactory
import android.os.Handler
import news.agoda.com.sample.util.constants.NEWS_ITEM


class MainActivity : BaseActivity<ActivityMainBinding>(), NewsListAdapter.ItemClick<NewsEntity>, SwipeRefreshLayout.OnRefreshListener {
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

        swipe_to_refresh.setOnRefreshListener(this)
    }

    private fun fetchList() {
        binding!!.showLoading = true
        if (isNetworkConnected(this)) {
            newsViewModel!!.fetchNewsList()
        } else {
            showToast("Internet Connection missing")
            binding!!.showLoading = false
        }

        if (swipe_to_refresh.isRefreshing)
            swipe_to_refresh.isRefreshing = false
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
        newsViewModel!!.getError().observe(this) {
            if (it != null) {
                binding!!.showLoading = false
                showToast("Something went wrong")
            }

        }
    }

    override fun onItemClick(newsEntity: NewsEntity) {
        val i = Intent(this, DetailViewActivity::class.java)
        i.putExtra(NEWS_ITEM, newsEntity)
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

    override fun onRefresh() {
        binding!!.showLoading = false
        Handler().postDelayed(Runnable {
            fetchList()
        }, 1000)
    }

}
