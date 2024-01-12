import lib.InvalidLocaleException
import java.util.*

fun readLocaleName(): String {
    val locals = hashSetOf("ru", "en")
    val line = readlnOrNull()

    if (!locals.contains(line)) {
        throw InvalidLocaleException("$line is not a valid locale, only $locals are supported")
    }

    return line!!
}

fun loadBundle(language: String): ResourceBundle {
    return ResourceBundle.getBundle("application", Locale(language))
}