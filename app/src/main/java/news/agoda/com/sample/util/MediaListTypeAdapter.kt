package news.agoda.com.sample.util

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import news.agoda.com.sample.model.MediaEntity
import java.io.IOException

class MediaListTypeAdapter: TypeAdapterFactory {
    override fun <T : Any?> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T>? {
        if (type?.rawType != List::class.java) {
            return null
        }
        val typeOfT = TypeToken.getParameterized(List::class.java, MediaEntity::class.java)
        if (type != typeOfT) return null
        val delegate = gson?.getDelegateAdapter(this, type)
        return object : TypeAdapter<T>() {
            @Throws(IOException::class)

            override fun write(out: JsonWriter, value: T) {

                delegate?.write(out, value)
            }

            @Throws(IOException::class)
            override fun read(input: JsonReader): T? {
                if (input.peek() == JsonToken.STRING) {
                    input.skipValue()
                    return null
                }
                return delegate?.read(input)
            }
        }

    }
}