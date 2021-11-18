package com.example.dnd5eplayerapp.database

import com.google.gson.annotations.SerializedName


data class MonsterInfo (
    val name: String,
    val type: String,
    val subtype: String,

    @SerializedName("armor_class")
    val armorClass: Float,

    @SerializedName("hit_points")
    val hitPoints: Float,

    @SerializedName("hit_dice")
    val hitDice: String,

//    val speed: Speed,
    val strength: Float,
    val dexterity: Float,
    val constitution: Float,
    val intelligence: Float,
    val wisdom: Float,
    val charisma: Float,
)

