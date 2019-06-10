package news.agoda.com.sample.ui.news

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import news.agoda.com.sample.databinding.ListItemBinding
import news.agoda.com.sample.model.NewsEntity


class NewsListAdapter(context: Context) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    private var listener: ItemClick<NewsEntity>? = null
    var newsList: List<NewsEntity>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    fun addListener(itemClick: ItemClick<NewsEntity>) {
        this.listener = itemClick
    }

    fun removeListener() {
        listener = null
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        return ViewHolder(ListItemBinding.inflate(layoutInflater, viewGroup, false))
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        newsList?.get(i)?.let {entity->
            viewHolder.itemView.tag = entity
            viewHolder.binding.news = entity

            try {
                if (entity.mediaEntityList!!.isNotEmpty()) {
                    val mediaEntity = entity.mediaEntityList[0]
                    val thumbnailURL = mediaEntity.url
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }


            viewHolder.binding.setItemClickListener { listener!!.onItemClick(entity) }
        }

    }

    override fun getItemCount(): Int {
        return newsList?.size ?: 0
    }

    class ViewHolder(internal val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.getRoot())

    interface ItemClick<T> {
        fun onItemClick(newsEntity: NewsEntity)
    }

}

