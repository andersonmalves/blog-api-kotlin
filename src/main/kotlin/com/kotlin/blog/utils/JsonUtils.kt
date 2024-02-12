import com.google.gson.Gson
import org.slf4j.LoggerFactory

object JsonUtils {
    private val gson = Gson()
    private val logger = LoggerFactory.getLogger(JsonUtils::class.java)

    fun toJson(obj: Any): String {
        return try {
            gson.toJson(obj)
        } catch (e: Exception) {
            logger.error("Erro ao converter objeto para JSON: {}", e.message)
            ""
        }
    }
}
