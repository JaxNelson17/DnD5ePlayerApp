package com.example.dnd5eplayerapp.ui.mainMenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.MainMenuFragmentBinding
import com.example.dnd5eplayerapp.ui.home.HomeFragment

class MainMenuFragment() : Fragment() {

    private lateinit var viewModel: MainMenuViewModel
    private lateinit var binding: MainMenuFragmentBinding
    private val adapter by lazy { MainMenuAdapter(viewModel) }

    val itemList = MainMenuItems.listOfItems

    val action =
        MainMenuFragmentDirections.actionMainMenuFragmentToHomeFragment()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.main_menu_fragment, container, false)


        val application = requireNotNull(this.activity).application

        val viewModelFactory = MainMenuViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainMenuViewModel::class.java)

        binding.mainMenuViewModel = viewModel

        binding.button.setOnClickListener {
            navigateToFragment()
        }

        viewModel.menuItemsList.observe(viewLifecycleOwner, Observer { item ->
            navigateToFragment()
        })


        binding.mainMenuView.adapter = adapter

        adapter.submitList(itemList)

        return binding.root
    }

    fun navigateToFragment() {
        parentFragmentManager.commit {
            replace<HomeFragment>(R.id.nav_host_fragment)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

}