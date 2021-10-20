package com.example.dnd5eplayerapp.ui.home

import android.content.ClipData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dnd5eplayerapp.database.ItemResponse
import com.example.dnd5eplayerapp.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeViewModel(private val repository: Repository): ViewModel() {

    var myCustomData: MutableLiveData<List<Response<ItemResponse>>> = MutableLiveData()

    fun getCustomData(count: String, result: String) {
        viewModelScope.launch {
            val response = repository.getMenuItems(count, result)
            var listToSubmit = listOf(response)
            myCustomData.value = listToSubmit
        }
    }
}