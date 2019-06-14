package news.agoda.com.sample.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class NewsEntity (@SerializedName("title")
                       @Expose
                       val title:String? = null,

                       @SerializedName("abstract")
                       @Expose
                       val summary:String? = null,

                       @SerializedName("url")
                       @Expose
                       val articleUrl:String? = null,

                       @SerializedName("byline")
                       @Expose
                       val byline:String,

                       @SerializedName("published_date")
                       @Expose
                       val publishedDate:String? = null,

                       @SerializedName("multimedia")
                       @Expose
                       val mediaEntityList:@RawValue List<MediaEntity>? = null):Parcelable{
    val imageUrl:String?
        get() = mediaEntityList?.firstOrNull()?.url
}