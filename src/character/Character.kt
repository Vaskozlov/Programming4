package character

import scene.SceneObject
import java.util.ResourceBundle


abstract class Character(name: String, val physicalParameters: PhysicalParameters) : SceneObject(name) {
    override fun equals(other: Any?): Boolean {
        if (other is Character) {
            return name == other.name;
        }

        return false;
    }

    override fun hashCode(): Int {
        return name.hashCode();
    }

    abstract fun takeBreath(bundle: ResourceBundle)

    abstract fun breakHead(bundle: ResourceBundle, reason: String)

    abstract fun thinkAbout(bundle: ResourceBundle, someThought: String)

    abstract fun cancelThoughts(bundle: ResourceBundle, reason: String)

    abstract fun describeState(bundle: ResourceBundle, state: String)

    abstract fun interactWithObject(bundle: ResourceBundle, sceneObject: SceneObject, description: String)

    abstract fun interactWithObject(
        bundle: ResourceBundle,
        sceneObject: SceneObject,
        description: String,
        action: (SceneObject) -> Any?,
    )
}