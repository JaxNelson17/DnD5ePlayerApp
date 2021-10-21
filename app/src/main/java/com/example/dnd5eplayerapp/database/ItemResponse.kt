package com.example.dnd5eplayerapp.database


data class ItemResponse (
    val count: Long,
    val results: List<Monster>
)

data class Monster (
    val index: String,
    val name: String,
    val url: String
)



