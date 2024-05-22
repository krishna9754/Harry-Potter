package com.example.harrypotter.repository
import com.example.harrypotter.data.api.CharacterItem
import com.example.harrypotter.data.apiservice.CharacterAPI
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val characterAPI: CharacterAPI
) {

    suspend fun getCharacters(): List<CharacterItem> {
        return characterAPI.getCharacter()
    }

}