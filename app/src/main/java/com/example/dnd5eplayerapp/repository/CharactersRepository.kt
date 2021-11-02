package com.example.dnd5eplayerapp.repository

import androidx.lifecycle.LiveData
import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.database.CharacterDao

class CharactersRepository(private val characterDao: CharacterDao) {

    val readAllData: LiveData<List<Character>> = characterDao.realAllData()

    suspend fun addCharacter(character: Character) {
        characterDao.addCharacter(character)
    }

    suspend fun updateCharacter(character: Character) {
        characterDao.updateCharacter(character)
    }

    suspend fun deleteCharacter(character: Character) {
        characterDao.deleteCharacter(character)
    }

    suspend fun deleteAllCharacters() {
        characterDao.deleteAllCharacters()
    }
}