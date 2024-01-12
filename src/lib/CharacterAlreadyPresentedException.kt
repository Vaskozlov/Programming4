package lib

class CharacterAlreadyPresentedException(message: String, cause: Throwable? = null) : StoryException(message, cause) {
}