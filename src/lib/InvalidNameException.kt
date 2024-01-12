package lib

class InvalidNameException(message: String, cause: Throwable? = null) : StoryException(message, cause) {
}