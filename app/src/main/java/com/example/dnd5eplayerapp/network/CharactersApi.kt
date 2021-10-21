package com.example.dnd5eplayerapp.network

import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.database.ItemResponse
import com.example.dnd5eplayerapp.database.Monster
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET("classes")
    suspend fun getCharacters(): Response<List<Character>>

    @GET("api/classes")
    suspend fun getMenuItems(
        @Query("results") results: String
    ) : Response<ItemResponse>

}