package police

import character.Character
import java.util.ResourceBundle

interface PoliceInterface {
    fun receiveCall(bundle: ResourceBundle, character: Character, reason: ReasonToCallThePolice, description: String)
}