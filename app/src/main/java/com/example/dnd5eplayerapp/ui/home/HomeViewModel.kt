package com.example.dnd5eplayerapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dnd5eplayerapp.database.ItemResponse
import com.example.dnd5eplayerapp.database.Monster
import com.example.dnd5eplayerapp.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository): ViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }

    private val _myCustomData = MutableLiveData<List<Monster>>()
    val myCustomData: LiveData<List<Monster>>
        get() = _myCustomData


    fun getCustomData(result: String) {
        viewModelScope.launch {
            val response = repository.getMenuItems(result)
            if (response.isSuccessful) {
                val monsters = response.body()?.results
                _myCustomData.value = monsters!!
            }
        }
    }

}