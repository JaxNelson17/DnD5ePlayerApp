package com.example.dnd5eplayerapp.ui.infoScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.InfoScreenBinding

class InfoFragment : Fragment() {

    private lateinit var viewModel: InfoViewModel
    private lateinit var binding: InfoScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.info_screen, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = InfoViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(InfoViewModel::class.java)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.mainMenuFragment)
        }


        return binding.root
    }
}