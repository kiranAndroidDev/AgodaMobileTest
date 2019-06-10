package news.agoda.com.sample.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * This class represents a media item
 */
@Parcelize
class MediaEntity(@field:SerializedName("url")
                  val url: String?, @field:SerializedName("format")
                  val format: String?, @field:SerializedName("height")
                  val height: Int?, @field:SerializedName("width")
                  val width: Int?, @field:SerializedName("type")
                  val type: String?, @field:SerializedName("subtype")
                  val subType: String?, @field:SerializedName("caption")
                  val caption: String?, @field:SerializedName("copyright")
                  val copyright: String?):Parcelable
