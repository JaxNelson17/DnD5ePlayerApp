package com.example.dnd5eplayerapp.ui.mainMenu

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainMenuViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainMenuViewModel::class.java)) {
            return MainMenuViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}