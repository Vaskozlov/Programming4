import character.Character
import character.PhysicalParameters
import character.SceneCharacter
import material.MaterialObject
import police.PoliceInterface
import police.ReasonToCallThePolice
import scene.Scene
import java.util.ResourceBundle
import kotlin.random.Random

val police: PoliceInterface = object : PoliceInterface {
    override fun receiveCall(
        bundle: ResourceBundle,
        character: Character,
        reason: ReasonToCallThePolice,
        description: String
    ) {
        System.out.printf(bundle.getString("police.call.description"), character, reason, description)
    }
}

fun main() {
    class PeachSeed(name: String) : MaterialObject(name) {
        fun measureGrowthInMM(): Double {
            return Random.nextDouble(0.0, 2.5);
        }
    }

    val bundle = loadBundle(readLocaleName())
    val scene = Scene(police)

    val boy = SceneCharacter(bundle.getString("name.Boy"), PhysicalParameters(160.0, 56.0, 10.0))
    val carlson = SceneCharacter(bundle.getString("name.Carlson"), PhysicalParameters(140.0, 120.0, -10.0))
    val filya = SceneCharacter(bundle.getString("name.Filya"), PhysicalParameters(170.0, 75.0, 15.0))
    val rulya = SceneCharacter(bundle.getString("name.Rulya"), PhysicalParameters(168.9, 65.4, 12.0))
    val peachSeed = PeachSeed(bundle.getString("object.material.peach.seed"))
    val window = MaterialObject(bundle.getString("object.material.window"))

    scene.addCharacters(boy, carlson, filya, rulya)
    scene.addMaterialObjects(peachSeed, window)

    boy.takeBreath(bundle)
    boy.breakHead(bundle, String.format(bundle.getString("boy.tries.to.save.carlson"), carlson, filya, rulya))
    boy.thinkAbout(bundle, bundle.getString("action.call.the.police"))
    boy.cancelThoughts(bundle, String.format(bundle.getString("boy.reason.to.cancel.thought"), filya, rulya, carlson))

    carlson.describeState(bundle, bundle.getString("carlson.state.1"))
    carlson.interactWithObject(bundle, window, bundle.getString("carlson.state.2"))
    carlson.interactWithObject(bundle, peachSeed, bundle.getString("carlson.state.3"))

    carlson.interactWithObject(
        bundle,
        peachSeed,
        bundle.getString("carlson.state.4")
    ){ seed -> (seed as PeachSeed).measureGrowthInMM() }

    boy.describeState(bundle, bundle.getString("boy.state.1"))
}