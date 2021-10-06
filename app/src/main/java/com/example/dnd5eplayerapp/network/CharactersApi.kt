package com.example.dnd5eplayerapp.network

import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.database.responseMenu
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CharactersApi {

    @GET("classes")
    suspend fun getCharacters(): Response<List<Character>>

    @GET("")
    suspend fun getMenu(@Url homePage: String) : Response<responseMenu>

}