package com.example.dnd5eplayerapp.ui.characterCreation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreationViewModel(application: Application) :  ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Welcome to the Character Creation Screen!!"
    }
    val text: LiveData<String> = _text
}