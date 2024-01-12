package lib

open class StoryException(message: String, cause: Throwable? = null) : Exception(message, cause) {
}