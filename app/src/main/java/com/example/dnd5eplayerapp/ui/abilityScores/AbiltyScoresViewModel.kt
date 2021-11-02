package com.example.dnd5eplayerapp.ui.abilityScores

import android.app.Application
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.database.CharacterDatabase
import com.example.dnd5eplayerapp.repository.CharactersRepository
import com.example.dnd5eplayerapp.ui.characterList.CharacterListFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AbiltyScoresViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Character>>
    private val repository: CharactersRepository

    init {
        val characterDao = CharacterDatabase.getDatabase(application).characterDao()
        repository = CharactersRepository(characterDao)
        readAllData = repository.readAllData
    }

    fun addCharacter(character: Character) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCharacter(character)
        }
    }

    fun updateCharacter(character: Character) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateCharacter(character)
        }
    }

    fun deleteCharacter(character: Character) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteCharacter(character)
        }
    }

    fun deleteAllCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllCharacters()
        }
    }

}