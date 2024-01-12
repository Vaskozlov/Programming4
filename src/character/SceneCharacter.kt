package character

import scene.SceneObject
import java.util.*

class SceneCharacter(name: String, physicalParameters: PhysicalParameters) : Character(name, physicalParameters) {
    override fun takeBreath(bundle: ResourceBundle) {
        println("$name ${bundle.getString("action.take.breath")}.")
    }

    override fun breakHead(bundle: ResourceBundle, reason: String) {
        println("$name ${bundle.getString("action.puzzle.over")} $reason.")
    }

    override fun thinkAbout(bundle: ResourceBundle, someThought: String) {
        println("$name ${bundle.getString("action.thinks")} $someThought.")
    }

    override fun cancelThoughts(bundle: ResourceBundle, reason: String) {
        println("$name ${bundle.getString("action.cancel.thought")} $name $reason.")
    }

    override fun describeState(bundle: ResourceBundle, state: String) {
        println("$name $state.")
    }

    override fun interactWithObject(bundle: ResourceBundle, sceneObject: SceneObject, description: String) {
        println("$name $description $sceneObject.")
    }

    override fun interactWithObject(
        bundle: ResourceBundle,
        sceneObject: SceneObject,
        description: String,
        action: (SceneObject) -> Any?,
    ) {
        println("$name $description $sceneObject.")
        action(sceneObject)
    }
}