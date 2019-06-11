package news.agoda.com.sample.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

 class NewsList (@SerializedName("status")
                 @Expose
                 val status:String,

                 @SerializedName("section")
                 @Expose
                 val section:String? = null,

                 @SerializedName("num_results")
                 @Expose
                 val totalResults:Int? = null,

                 @SerializedName("results")
                 @Expose
                 val results:List<NewsEntity>? = null){


}
