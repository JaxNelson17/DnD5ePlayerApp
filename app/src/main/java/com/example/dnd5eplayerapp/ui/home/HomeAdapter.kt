package com.example.dnd5eplayerapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.database.ItemResponse
import com.example.dnd5eplayerapp.database.Monster
import com.example.dnd5eplayerapp.databinding.HomeRecyclerviewItemBinding
import kotlinx.android.synthetic.main.home_recyclerview_item.view.*

class HomeAdapter (

        ) : ListAdapter <ItemResponse, HomeAdapter.HomeViewHolder>() {

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
            var item = getItem(position)


            var count = binding.countTxt
            var result = binding.resultsTxt
            var url = binding.urlTxt


            count.text = item.results[position].name
            Log.i("position", "${item}")
            //result.text = item.results.toString()
            url.text = item.results[position].url
        }
    }
}