package com.example.dnd5eplayerapp.ui.diceRoller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.DiceRollerBinding
import com.example.dnd5eplayerapp.ui.characterCreation.CreationViewModel

class DiceRollerFragment : Fragment() {

    private lateinit var binding: DiceRollerBinding
    private lateinit var viewModel: DiceRollerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.dice_roller, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = DiceRollerViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(DiceRollerViewModel::class.java)

        binding.diceRollerViewModel = viewModel

        return binding.root
    }
}