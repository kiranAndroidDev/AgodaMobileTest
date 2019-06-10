package news.agoda.com.sample.util

import android.widget.ImageView


import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import news.agoda.com.sample.R

/**
 * Created by kiranb on 10/6/19
 */

    @BindingAdapter("imgSrc")
    fun setImgSrc(img: ImageView, url: String?) {
        if(url == "" || url == null)
        Picasso.with(img.context)
                .load(R.drawable.place_holder)
                .placeholder(R.drawable.place_holder)
                .into(img)
        else
            Picasso.with(img.context)
                    .load(url)
                    .placeholder(R.drawable.place_holder)
                    .into(img)

}
