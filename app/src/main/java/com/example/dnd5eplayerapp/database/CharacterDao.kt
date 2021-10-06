package com.example.dnd5eplayerapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: List<Character>)

    @Query("SELECT * FROM character_table WHERE id = :key")
    suspend fun get(key: Int): Character?
}