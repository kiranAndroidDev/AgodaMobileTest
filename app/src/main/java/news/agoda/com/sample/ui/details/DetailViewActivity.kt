package news.agoda.com.sample.ui.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View

import news.agoda.com.sample.R
import news.agoda.com.sample.base.BaseActivity
import news.agoda.com.sample.databinding.ActivityDetailBinding
import news.agoda.com.sample.model.NewsEntity
import java.lang.Exception

/**
 * News detail view
 */
class DetailViewActivity : BaseActivity<ActivityDetailBinding>() {
    override fun getLayoutId(): Int = R.layout.activity_detail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val extras = intent.extras
        val newsEntity = extras?.getParcelable("NewsItem") as NewsEntity?
        binding!!.news = newsEntity
        binding!!.clickListener = View.OnClickListener {
            onFullStoryClicked(newsEntity?.articleUrl)
        }
        try {
            val url = newsEntity?.mediaEntityList?.get(0)?.url
            /* val draweeController = Fresco.newDraweeControllerBuilder()
                     .setImageRequest(ImageRequest.fromUri(Uri.parse(url)))
                     .setOldController(binding!!.newsImage.controller).build()
             binding!!.newsImage.controller = draweeController*/

           } catch (e: Exception) {
        }
        binding!!.executePendingBindings()
    }

    fun onFullStoryClicked(url: String?) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
