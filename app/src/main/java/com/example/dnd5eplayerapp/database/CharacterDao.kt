package com.example.dnd5eplayerapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCharacter(character: Character)

    @Update
    suspend fun updateCharacter(character: Character)

    @Query("SELECT * FROM character_table ORDER BY id ASC")
    fun realAllData(): LiveData<List<Character>>
}