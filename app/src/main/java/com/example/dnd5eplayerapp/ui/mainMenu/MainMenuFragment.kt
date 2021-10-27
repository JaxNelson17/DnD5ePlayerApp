package com.example.dnd5eplayerapp.ui.mainMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.MainMenuFragmentBinding

class MainMenuFragment() : Fragment() {

    private lateinit var viewModel: MainMenuViewModel
    private lateinit var binding: MainMenuFragmentBinding
    private val adapter by lazy { MainMenuAdapter(viewModel) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_menu_fragment, container, false)

        val application = requireNotNull(this.activity).application

        val viewModelFactory = MainMenuViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainMenuViewModel::class.java)

        binding.mainMenuViewModel = viewModel


        viewModel.listOfMenuItems.observe(viewLifecycleOwner, Observer { menuItems ->
            adapter.submitList(menuItems)
        })

        binding.mainMenuView.adapter = adapter

        return binding.root
    }

}