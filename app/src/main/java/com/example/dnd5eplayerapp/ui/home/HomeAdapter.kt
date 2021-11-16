package com.example.dnd5eplayerapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.database.MonsterInfo
import com.example.dnd5eplayerapp.databinding.HomeRecyclerviewItemBinding

class HomeAdapter (

        ) : ListAdapter <MonsterInfo, HomeAdapter.HomeViewHolder>(HomeListDiffCallback()) {

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

            var action = binding.actionText


        }
    }
}

class HomeListDiffCallback : DiffUtil.ItemCallback<MonsterInfo>() {
    override fun areItemsTheSame(oldItem: MonsterInfo, newItem: MonsterInfo): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MonsterInfo, newItem: MonsterInfo): Boolean {
        return oldItem == newItem
    }

}