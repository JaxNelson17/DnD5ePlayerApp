package com.example.dnd5eplayerapp.ui.mainMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.MainMenuFragmentBinding
import com.example.dnd5eplayerapp.ui.characterCreation.CreationFragment

class MainMenuFragment() : Fragment() {

    private lateinit var viewModel: MainMenuViewModel
    private lateinit var binding: MainMenuFragmentBinding
    private val adapter by lazy { MainMenuAdapter(viewModel) }

    val itemList = MainMenuItems.listOfItems

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_menu_fragment, container, false)


        val application = requireNotNull(this.activity).application

        val viewModelFactory = MainMenuViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainMenuViewModel::class.java)

        binding.mainMenuViewModel = viewModel

        viewModel.menuItemsList.observe(viewLifecycleOwner, Observer { item ->
            findNavController().navigate(R.id.characterListFragment)
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.infoFragment)
        }

        binding.floatingActionButton2.setOnClickListener {
            findNavController().navigate(R.id.diceRollerFragment)
        }

        binding.mainMenuView.adapter = adapter

        adapter.submitList(itemList)

        return binding.root
    }
}