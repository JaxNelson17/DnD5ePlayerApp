package com.example.dnd5eplayerapp.network

import com.example.dnd5eplayerapp.database.Character
import retrofit2.Response
import retrofit2.http.GET

interface CharactersApi {

    @GET("classes")
    suspend fun getClasses(): Response<List<Character>>
}