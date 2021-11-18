package com.example.dnd5eplayerapp.database

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class ItemResponse (
    val count: Long,
    val results: List<ApiItem>
)

data class ApiItem (
    val index: String,
    val name: String,
    val url: String
)

@Parcelize
data class MenuItem (
    val id: Int,
    val image: Int,
    val name: String
    ) : Parcelable



