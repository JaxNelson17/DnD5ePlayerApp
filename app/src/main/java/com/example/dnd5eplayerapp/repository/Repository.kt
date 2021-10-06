package com.example.dnd5eplayerapp.repository

import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.database.Classes
import com.example.dnd5eplayerapp.database.responseMenu
import com.example.dnd5eplayerapp.network.RetroFitInstance
import retrofit2.Response

class Repository {

    suspend fun getCharacters(): Response<List<Character>> {
        return RetroFitInstance.api.getCharacters()
    }

    suspend fun getMenuItems(menu: String) : Response<responseMenu> {
        return RetroFitInstance.api.getMenu(menu)
    }

    suspend fun getClasses(classes: String) : Response<Classes> {
        return RetroFitInstance.api.getClasses(classes)
    }
}