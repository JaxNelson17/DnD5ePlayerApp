package com.example.dnd5eplayerapp.repository

import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.database.ItemResponse
import com.example.dnd5eplayerapp.database.MonsterInfo
import com.example.dnd5eplayerapp.network.RetroFitInstance
import retrofit2.Response

class Repository {

    suspend fun getCharacters(): Response<List<Character>> {
        return RetroFitInstance.api.getCharacters()
    }

    suspend fun getMenuItems(results: String) : Response<ItemResponse> {
        return RetroFitInstance.api.getMenuItems(results)
    }

    suspend fun getMonster(name: String): Response<MonsterInfo> {
        return RetroFitInstance.api.getMonsters(name)
    }

}