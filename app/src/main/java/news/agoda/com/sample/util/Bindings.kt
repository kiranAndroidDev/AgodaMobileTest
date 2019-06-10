package news.agoda.com.sample.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import news.agoda.com.sample.R

/**
Created by kiranb on 10/6/19
 */
 object Bindings {
       @JvmStatic @BindingAdapter("android:src")
        fun setImage(img:ImageView, url: String) {
            Glide.with(img.context)
                    .load(url)
                    .placeholder(R.drawable.place_holder)
                    .into(img)

    }
}