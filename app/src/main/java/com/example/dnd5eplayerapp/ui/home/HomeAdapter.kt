package com.example.dnd5eplayerapp.ui.home

import android.app.ActionBar
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.databinding.HomeRecyclerviewItemBinding
import java.text.FieldPosition

class HomeAdapter(
    ) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ) : HomeAdapter.HomeViewHolder {
        val view = HomeRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: HomeAdapter.HomeViewHolder,
        position: Int
    ) {
        holder.bind(position)
    }

    inner class HomeViewHolder(val binding: HomeRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {

        }

    }

    override fun getItemCount(): Int {
        return 5
    }
}