package com.example.dnd5eplayerapp.ui.diceRoller

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DiceRollerViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiceRollerViewModel::class.java)) {
            return DiceRollerViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}