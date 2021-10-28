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

    private val _selectedItem = MutableLiveData<MenuItem?>()
    val selectedItem: LiveData<MenuItem?>
        get() = _selectedItem

    private val _itemNumber = MutableLiveData<Int>()
    val itemNumber: LiveData<Int>
        get() = _itemNumber

    init {
        _selectedItem.value = null
    }


    fun navigationComplete() {
        _selectedItem.value = null
    }

    fun setMenuItem(menuItems: MenuItem) {
        _menuItemsList.value =menuItems
    }

    fun setMenuItems(menuItems: List<MenuItem>) {
        _listOfMenuItems.value = menuItems
    }

    // pass in id here
    fun navigateToFragment(test: Int) {

    }

}

object MainMenuItems {
    val listOfItems = mutableListOf<MenuItem>(
        MenuItem(1 ,R.drawable.list, "Character Creation"),
        MenuItem( 2,R.drawable.character_icon, "Character List")
    )
}