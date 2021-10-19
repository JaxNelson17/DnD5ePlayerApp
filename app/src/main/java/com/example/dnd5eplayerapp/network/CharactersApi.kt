package com.example.dnd5eplayerapp.network

import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.database.itemResponse
import com.example.dnd5eplayerapp.database.responseMenu
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface CharactersApi {

    @GET("classes")
    suspend fun getCharacters(): Response<List<Character>>

    @GET("api/rule-sections")
    suspend fun getMenuItems(
        @Query("count") count: String,
        @Query("result") result: String
    ) : Response<itemResponse>

}