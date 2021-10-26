package com.example.dnd5eplayerapp.ui.mainMenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.database.Monster
import com.example.dnd5eplayerapp.databinding.MainMenuItemBinding

class MainMenuAdapter : RecyclerView.Adapter<MainMenuAdapter.MainMenuViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_menu_item, parent, false)
        return MainMenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainMenuViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class MainMenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
