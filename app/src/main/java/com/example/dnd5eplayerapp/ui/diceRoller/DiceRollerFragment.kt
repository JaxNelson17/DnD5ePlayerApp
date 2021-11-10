package com.example.dnd5eplayerapp.ui.diceRoller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.DiceRollerBinding

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

        binding.d20Roll.setOnClickListener {
            binding.d20Result.text = viewModel.rollD20().toString()
        }

        binding.d12Roll.setOnClickListener {
            binding.d12Result.text = viewModel.rollD12().toString()
        }

        binding.d10Roll.setOnClickListener {
            binding.d10Result.text = viewModel.rollD10().toString()
        }

        binding.d10Roll2.setOnClickListener {
            binding.d10Result2.text = viewModel.rollD10Two().toString()
        }

        binding.d8Roll.setOnClickListener {
            binding.d8Result.text = viewModel.rollD8().toString()
        }

        binding.d6Roll.setOnClickListener {
            binding.d6Result.text = viewModel.rollD6().toString()
        }

        binding.d4Roll.setOnClickListener {
            binding.d4Result.text = viewModel.rollD4().toString()
        }

        binding.navBack.setOnClickListener {
            findNavController().navigate(R.id.mainMenuFragment)
        }

        return binding.root
    }
}