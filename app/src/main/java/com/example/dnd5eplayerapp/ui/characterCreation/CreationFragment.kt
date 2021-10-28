package com.example.dnd5eplayerapp.ui.characterCreation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.CreationFragmentBinding

class CreationFragment() : Fragment() {

    private lateinit var viewModel: CreationViewModel
    private lateinit var binding: CreationFragmentBinding

    override fun onCreate(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.creation_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = CreationViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CreationViewModel::class.java)

        binding.creationViewModel = viewModel

        return binding.root
    }

}