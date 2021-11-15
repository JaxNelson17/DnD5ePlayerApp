package com.example.dnd5eplayerapp.network

import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.database.ItemResponse
import com.example.dnd5eplayerapp.database.MonsterInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharactersApi {

    @GET("classes")
    suspend fun getCharacters(): Response<List<Character>>

    @GET("api/monsters")
    suspend fun getMenuItems(
        @Query("results") results: String
    ) : Response<ItemResponse>

    @GET("api/monsters/{names}")
    suspend fun getMonsters(
        @Path("names") names: String
    ) : Response<MonsterInfo>



}