package com.example.dnd5eplayerapp.ui.characterCreation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dnd5eplayerapp.ui.mainMenu.MainMenuViewModel

class CreationViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CreationViewModel::class.java)) {
            return CreationViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}