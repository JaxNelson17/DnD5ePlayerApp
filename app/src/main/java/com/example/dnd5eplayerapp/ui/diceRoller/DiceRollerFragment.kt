package com.example.dnd5eplayerapp.ui.diceRoller

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
            val total = viewModel.rollD20().toString()
            binding.d20Result.text = total
            Toast.makeText(requireContext(), "Your roll was $total", Toast.LENGTH_SHORT).show()
        }

        binding.d12Roll.setOnClickListener {
            val total = viewModel.rollD12().toString()
            binding.d12Result.text = total
            Toast.makeText(requireContext(), "Your roll was $total", Toast.LENGTH_SHORT).show()
        }

        binding.d10Roll.setOnClickListener {
            val total = viewModel.rollD10().toString()
            binding.d10Result.text = total
            Toast.makeText(requireContext(), "Your roll was $total", Toast.LENGTH_SHORT).show()
        }

        binding.d10Roll2.setOnClickListener {
            val total = viewModel.rollD10Two().toString()
            binding.d10Result2.text = total
            Toast.makeText(requireContext(), "Your roll was $total", Toast.LENGTH_SHORT).show()
        }

        binding.d8Roll.setOnClickListener {
            val total = viewModel.rollD8().toString()
            binding.d8Result.text = total
            Toast.makeText(requireContext(), "Your roll was $total", Toast.LENGTH_SHORT).show()
        }

        binding.d6Roll.setOnClickListener {
            val total = viewModel.rollD6().toString()
            binding.d6Result.text =  total
            Toast.makeText(requireContext(), "Your roll was $total", Toast.LENGTH_SHORT).show()
        }

        binding.d4Roll.setOnClickListener {
            val total = viewModel.rollD4().toString()
            binding.d4Result.text = total
            Toast.makeText(requireContext(), "Your roll was $total", Toast.LENGTH_SHORT).show()
        }

        binding.navBack.setOnClickListener {
            findNavController().navigate(R.id.mainMenuFragment)
        }

        return binding.root
    }
}