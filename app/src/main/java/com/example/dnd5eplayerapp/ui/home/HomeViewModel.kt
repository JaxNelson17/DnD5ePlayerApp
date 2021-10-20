package com.example.dnd5eplayerapp.ui.home

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log
import androidx.lifecycle.*
import com.example.dnd5eplayerapp.database.ItemResponse
import com.example.dnd5eplayerapp.database.Monster
import com.example.dnd5eplayerapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository): ViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }

    private val _myCustomData = MutableLiveData<List<Monster>>()
    val myCustomData: LiveData<List<Monster>>
        get() = _myCustomData




    fun getCustomData(count: String, result: String) {
        viewModelScope.launch {
            val response = repository.getMenuItems(count, result)
            listOf(response).map { response ->
                var listOfResults = response.body()?.results
                _myCustomData.value = listOfResults!! }
        }
    }

}