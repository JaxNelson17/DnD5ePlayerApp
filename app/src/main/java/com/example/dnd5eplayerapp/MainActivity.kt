package com.example.dnd5eplayerapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dnd5eplayerapp.repository.Repository
import com.example.dnd5eplayerapp.ui.home.HomeAdapter
import com.example.dnd5eplayerapp.ui.home.HomeViewModel
import com.example.dnd5eplayerapp.ui.home.HomeViewModelFactory
import kotlinx.android.synthetic.main.home_fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: HomeViewModel
    private val myAdapter by lazy { HomeAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_fragment)

        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = HomeViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        viewModel.getCustomData("5","")
        viewModel.myCustomData.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
                Log.i("response", "the response is ${response}")
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun setupRecyclerview() {
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}