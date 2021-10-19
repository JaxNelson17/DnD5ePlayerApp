package com.example.dnd5eplayerapp.ui.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dnd5eplayerapp.database.itemResponse
import com.example.dnd5eplayerapp.database.responseMenu
import com.example.dnd5eplayerapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository): ViewModel() {

    var myCustomData: MutableLiveData<Response<itemResponse>> = MutableLiveData()

    fun getCustomData(count: String, result: String) {
        viewModelScope.launch {
            val response = repository.getMenuItems(count, result)
            myCustomData.value = response
        }
    }
}