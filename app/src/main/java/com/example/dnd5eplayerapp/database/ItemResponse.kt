package com.example.dnd5eplayerapp.database

import android.widget.ImageView


data class ItemResponse (
    val count: Long,
    val results: List<Monster>
)

data class Monster (
    val index: String,
    val name: String,
    val url: String
)

data class MenuItem (
    val image: Int,
    val name: String
    )



