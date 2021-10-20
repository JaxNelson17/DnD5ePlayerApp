package com.example.dnd5eplayerapp.repository

import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.database.ItemResponse
import com.example.dnd5eplayerapp.network.RetroFitInstance
import retrofit2.Response

class Repository {

    suspend fun getCharacters(): Response<List<Character>> {
        return RetroFitInstance.api.getCharacters()
    }

    suspend fun getMenuItems(count: String, result: String) : Response<ItemResponse> {
        return RetroFitInstance.api.getMenuItems(count, result)
    }
}