package com.example.dnd5eplayerapp.network

import com.example.dnd5eplayerapp.utils.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: CharactersApi by lazy {
        retrofit.create(CharactersApi::class.java)
    }
}