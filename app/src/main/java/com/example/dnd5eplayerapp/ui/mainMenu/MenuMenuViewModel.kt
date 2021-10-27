package com.example.dnd5eplayerapp.ui.mainMenu

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.database.MenuItem

class MainMenuViewModel(
    application: Application
) : ViewModel() {

    private val _menuItemsList= MutableLiveData<MenuItem>()
    val menuItemsList: LiveData<MenuItem>
        get() = _menuItemsList

    private val _listOfMenuItems = MutableLiveData<List<MenuItem>>()
    val listOfMenuItems : LiveData<List<MenuItem>>
        get() = _listOfMenuItems

    init {
        setMenuItems(MainMenuItems.listOfItems)
    }

    fun setMenuItem(menuItems: MenuItem) {
        _menuItemsList.value =menuItems
    }


    fun setMenuItems(menuItems: List<MenuItem>) {
        _listOfMenuItems.value = menuItems
    }

}

object MainMenuItems {
    val listOfItems = mutableListOf<MenuItem>(
        MenuItem(R.drawable.list, "Character Creation"),
        MenuItem(R.drawable.character_icon, "Character List")
    )
}