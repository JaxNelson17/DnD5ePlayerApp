package com.example.dnd5eplayerapp.database


data class itemResponse (
    val count: Long,
    val results: List<Result>
)

data class Result (
    val index: String,
    val name: String,
    val url: String
)



