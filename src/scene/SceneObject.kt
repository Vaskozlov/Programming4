package scene

import lib.IdFactory
import lib.InvalidNameException

open class SceneObject(val name: String) {
    companion object {
        private var idFactory = IdFactory()
    }

    init {
        if (name.isEmpty()) {
            throw InvalidNameException("Name must contain at least one character");
        }
    }

    val id = idFactory.generateId()

    override fun toString(): String {
        return name
    }

    override fun hashCode(): Int {
        return id
    }

    override fun equals(other: Any?): Boolean {
        if (other is SceneObject) {
            return id == other.id
        }

        return false
    }
}