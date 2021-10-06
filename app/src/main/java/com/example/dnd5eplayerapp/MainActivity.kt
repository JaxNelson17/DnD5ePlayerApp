package com.example.dnd5eplayerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.dnd5eplayerapp.repository.Repository
import kotlinx.coroutines.launch




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_fragment)

        val repository = Repository()

        lifecycleScope.launch {
            val response = repository.getMenuItems("https://www.dnd5eapi.co/api/")
            val response2 = repository.getClasses("https://www.dnd5eapi.co/api")
            if (response.isSuccessful) {
                Log.i("menu", "menu is ${response.body()}")
            }
            if (response2.isSuccessful) {
                Log.i("classes", "classes are ${response2.body()}")
            } else {
                Log.i("classes", "classes are failed to get classes")
            }
        }
    }
}