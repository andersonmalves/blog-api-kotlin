import com.google.gson.Gson

object JsonUtils {
    private val gson = Gson()

    fun toJson(obj: Any): String {
        return gson.toJson(obj)
    }
}
