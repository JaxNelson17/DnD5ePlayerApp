package com.example.dnd5eplayerapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCharacter(character: Character)

    @Query("SELECT * FROM character_table ORDER BY id ASC")
    fun realAllData(): LiveData<List<Character>>
}