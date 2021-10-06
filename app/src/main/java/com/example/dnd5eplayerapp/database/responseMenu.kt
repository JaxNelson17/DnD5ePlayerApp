package com.example.dnd5eplayerapp.database

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import java.util.concurrent.locks.Condition

data class responseMenu (
    @SerializedName("ability-scores")
    var abilityScores: String,

    var alignments: String,
    var backgrounds: String,
    var classes: String,
    var conditions: String,

    @SerializedName("damage-types")
    var damageTypes: String,

    @SerializedName("equipment-categories")
    var equipmentCategories: String,

    var equipment: String,
    var feats: String,
    var features: String,
    var languages: String,

    @SerializedName("magic-items")
    var magicItems: String,

    @SerializedName("magic-schools")
    var magicSchools: String,

    var monsters: String,
    var proficiencies: String,
    var races: String,
    var rules: String,

    @SerializedName("rule-sections")
    var ruleSections: String,

    var skills: String,
    var spells: String,
    var subclasses: String,
    var subraces: String,
    var traits: String,

    @SerializedName("weapon-properties")
    var weaponProperties: String
)