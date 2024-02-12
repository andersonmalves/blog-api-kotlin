import com.google.gson.Gson
import org.slf4j.LoggerFactory

/**
 * Classe utilitária para operações JSON.
 */
object JsonUtils {
    private val logger = LoggerFactory.getLogger("JsonUtils")
    private val gson = Gson()

    /**
     * Converte um objeto em formato JSON.
     * @param obj O objeto a ser convertido em JSON.
     * @return Uma string contendo a representação JSON do objeto.
     */
    fun toJson(obj: Any): String {
        return try {
            gson.toJson(obj)
        } catch (e: Exception) {
            logger.error("Erro ao converter objeto para JSON: {}", e.message)
            ""
        }
    }

    /**
     * Converte uma string JSON em um objeto do tipo especificado.
     * @param json A string JSON a ser convertida.
     * @param classOfT A classe do tipo do objeto para o qual o JSON será convertido.
     * Ex.: JsonUtils.fromJson(json, MyObject::class.java)
     * @return O objeto do tipo especificado, ou null se a conversão falhar.
     */
    fun <T> fromJson(json: String, classOfT: Class<T>): T? {
        return try {
            gson.fromJson(json, classOfT)
        } catch (e: Exception) {
            logger.error("Erro ao converter JSON para objeto: {}", e.message)
            null
        }
    }
}