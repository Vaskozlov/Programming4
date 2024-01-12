package scene

import character.Character
import material.MaterialObject
import police.PoliceInterface
import kotlin.collections.ArrayList;
import lib.CharacterAlreadyPresentedException

class Scene(val policeInterface: PoliceInterface) {
    private var characters = HashMap<String, Character>()
    private var materialObjects = ArrayList<MaterialObject>()

    fun addCharacters(vararg newCharacters: Character) {
        for (character in newCharacters) {
            checkCharacterIsNotPresent(character)
            characters[character.name] = character
        }
    }

    fun addMaterialObjects(vararg newMaterialObject: MaterialObject) {
        materialObjects.addAll(newMaterialObject)
    }

    fun getCharacterByName(name: String): Character? {
        return characters[name]
    }

    fun getObjectById(id: Int): SceneObject? {
        val suitableCharacter = findObjectByIdAmongCharacters(id)

        if (suitableCharacter == null) {
            return materialObjects.find { it.id == id }
        }

        return null
    }

    private fun checkCharacterIsNotPresent(character: Character) {
        if (characters.containsKey(character.name)) {
            throw CharacterAlreadyPresentedException("character ${character.name} is already in the scene")
        }
    }

    private fun findObjectByIdAmongCharacters(id: Int): Character? {
        return characters.values.find { it.id == id }
    }
}