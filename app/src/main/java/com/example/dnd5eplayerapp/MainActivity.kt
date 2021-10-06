package com.example.dnd5eplayerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.repository.Repository
import com.example.dnd5eplayerapp.ui.home.HomeAdapter
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_fragment)

        val repository = Repository()

        lifecycleScope.launch {
            val response = repository.getMenuItems("https://www.dnd5eapi.co/api/")
            if (response.isSuccessful) {
                Log.i("menu", "menu is ${response.body()}")
            }
        }

        recyclerView = findViewById(R.id.home_view)
        adapter = HomeAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }
}