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

    @ColumnInfo(name = "character_name")
    var characterName: String,

    @ColumnInfo(name = "class")
    var characterClass: String,

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

    @ColumnInfo(name = "level")
    var level: Int,

    ) : Parcelable {}
