package com.example.dnd5eplayerapp.database

import android.os.Parcelable
import android.telephony.CellSignalStrength
import android.widget.GridLayout
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "character_table")
data class Character (
    @PrimaryKey(autoGenerate = true)
    var id: Int,

//    @ColumnInfo(name = "character_name")
//    var characterName: String,
//
//    @ColumnInfo(name = "class")
//    var characterClass: String,
//
//    @ColumnInfo(name = "race")
//    var race: String,

    @ColumnInfo(name = "strength")
    var strength: Int,

    @ColumnInfo(name = "dexterity")
    var dexterity: Int,

    @ColumnInfo(name = "constitution")
    var constitution: Int,

    @ColumnInfo(name = "intelligence")
    var intelligence: Int,

    @ColumnInfo(name = "wisdom")
    var wisdom: Int,

    @ColumnInfo(name = "charisma")
    var charisma: Int,
//
//    @ColumnInfo(name = "level")
//    var level: Int,
//
//    @ColumnInfo(name = "background")
//    var background: String,
//
//    @ColumnInfo(name = "skills")
//    var skills: String,
//
//    @ColumnInfo(name = "hit_points")
//    var hitPoints: Int,
//
//    @ColumnInfo(name ="alignment")
//    var alignment: String,
//
//    @ColumnInfo(name = "primary_weapons")
//    var primaryWeapons: String,
//
//    @ColumnInfo(name = "secondary_weapons")
//    var secondaryWeapons: String,
//
//    @ColumnInfo(name = "armor")
//    var armor: String,
//
//    @ColumnInfo(name = "pack")
//    var pack: String,
//
//    @ColumnInfo(name = "age")
//    var age: Int,
//
//    @ColumnInfo(name = "weight")
//    var weight: Double,
//
//    @ColumnInfo(name = "height")
//    var height: Int,
//
//    @ColumnInfo(name = "eye_color")
//    var eyeColor: String,
//
//    @ColumnInfo(name = "skin_color")
//    var skinColor: String,
//
//    @ColumnInfo(name = "hair")
//    var hair: String,
//
//    @ColumnInfo(name = "personality_traits1")
//    var personalityTraits1: String,
//
//    @ColumnInfo(name = "personality_traits2")
//    var personalityTraits2: String,
//
//    @ColumnInfo(name = "ideals")
//    var ideals: String,
//
//    @ColumnInfo(name = "Bonds")
//    var bonds: String,
//
//    @ColumnInfo(name = "Flaws")
//    var flaws: String
    ) : Parcelable {}
