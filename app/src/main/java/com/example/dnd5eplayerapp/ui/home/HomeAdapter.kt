package com.example.dnd5eplayerapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.database.Monster
import com.example.dnd5eplayerapp.databinding.HomeRecyclerviewItemBinding

class HomeAdapter (

        ) : ListAdapter <Monster, HomeAdapter.HomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        val view =
            HomeRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class HomeViewHolder(val binding: HomeRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val item = getItem(position)


            val count = binding.countTxt
            val result = binding.resultsTxt
            val url = binding.urlTxt


            count.text = item.name
            Log.i("position", "$item")
            url.text = item.url
        }
    }
}