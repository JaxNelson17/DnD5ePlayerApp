package com.example.dnd5eplayerapp.ui.mainMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.MainMenuItemBinding

class MainMenuFragment() : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainMenuAdapter
    private lateinit var binding: MainMenuItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        recyclerView = inflater.inflate(R.layout.main_menu_item, container, false) as RecyclerView
        recyclerView.adapter = adapter

        return binding.root
    }
}