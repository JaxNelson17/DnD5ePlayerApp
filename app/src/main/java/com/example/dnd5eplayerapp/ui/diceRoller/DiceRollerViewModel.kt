package com.example.dnd5eplayerapp.ui.diceRoller

import android.app.Application
import androidx.lifecycle.ViewModel
import java.util.*

class DiceRollerViewModel(application: Application) : ViewModel() {

    fun rollD20(): Int {
        val range = 1..20
        return range.random()
    }

    fun rollD12(): Int {
        val range = 1..12
        return range.random()
    }

    fun rollD10(): Int {
        val range = 1..10
        return range.random()
    }

    fun rollD10Two(): Int {
        val range = 1..10
        return range.random() * 10
    }

    fun rollD8() : Int {
        val range = 1..8
        return range.random()
    }

    fun rollD6() : Int {
        val range = 1..6
        return range.random()
    }

    fun rollD4() : Int {
        val range = 1..4
        return range.random()
    }
}