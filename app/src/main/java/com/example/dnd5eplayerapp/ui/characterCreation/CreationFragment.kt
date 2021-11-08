package com.example.dnd5eplayerapp.ui.characterCreation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.CreationFragmentBinding
import com.example.dnd5eplayerapp.ui.abilityScores.AbilityScoresFragment
import com.example.dnd5eplayerapp.ui.characterList.CharacterListFragment
import com.example.dnd5eplayerapp.ui.home.HomeFragment

class CreationFragment() : Fragment() {

    private lateinit var viewModel: CreationViewModel
    private lateinit var binding: CreationFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.creation_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = CreationViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(CreationViewModel::class.java)

        binding.creationViewModel = viewModel

        val textView: TextView = binding.mainTextView
        viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        binding.startButton.setOnClickListener {
            findNavController().navigate(R.id.abilityScoresFragment)
        }

        return binding.root
    }
}