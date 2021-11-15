package com.example.dnd5eplayerapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dnd5eplayerapp.database.Action
import com.example.dnd5eplayerapp.database.ApiItem
import com.example.dnd5eplayerapp.database.MonsterInfo
import com.example.dnd5eplayerapp.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository): ViewModel() {

    companion object {
        const val TAG = "HomeViewModel"
    }



    private val _myCustomMonster = MutableLiveData<retrofit2.Response<MonsterInfo>>()
    val myCustomMonster: LiveData<retrofit2.Response<MonsterInfo>>
        get() = _myCustomMonster

    private val _myCustomMonster2 = MutableLiveData<retrofit2.Response<Action>>()
    val myCustomMonster2: LiveData<retrofit2.Response<Action>>
        get() = _myCustomMonster2

    private val _customActions = MutableLiveData<List<MonsterInfo>>()
    val customActions: LiveData<List<MonsterInfo>>
        get() = _customActions

    private val _myCustomData = MutableLiveData<List<ApiItem>>()
    val myCustomData: LiveData<List<ApiItem>>
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

    fun getMonsters(names: String) {
        viewModelScope.launch {
            val response = repository.getMonster(names)
            _myCustomMonster.value = response
        }


    }

}