package com.example.dnd5eplayerapp.repository

import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.network.RetroFitInstance
import retrofit2.Response

class Repository() {

    suspend fun getClasses(): Response<List<Character>> {
        return RetroFitInstance.api.getClasses()
    }
}