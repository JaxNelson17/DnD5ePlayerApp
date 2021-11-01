package com.example.dnd5eplayerapp.ui.abilityScores

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.database.Character
import kotlinx.android.synthetic.main.ab_scores_fragment.*
import kotlinx.android.synthetic.main.ab_scores_fragment.view.*

class AbilityScoresFragment : Fragment() {

    private lateinit var viewModel: AbiltyScoresViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.ab_scores_fragment, container,false)

        viewModel = ViewModelProvider(this).get(AbiltyScoresViewModel::class.java)

        view.add_character_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val str = strText.text
        val dex= dexText.text
        val cons = consText.text
        val intel = intelText.text
        val wis = wisText.text
        val char = charText.text

        if (inputCheck(str, dex, cons, intel, wis, char)) {
            val character = Character(0, Integer.parseInt(str.toString()), Integer.parseInt(dex.toString()), Integer.parseInt(cons.toString()), Integer.parseInt(intel.toString()), Integer.parseInt(wis.toString()), Integer.parseInt(char.toString()))
            viewModel.addCharacter(character)
            Toast.makeText(requireContext(), "Added in!!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(requireContext(), "Didn't work", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(str: Editable, dex: Editable, cons: Editable, intel: Editable, wis: Editable, char: Editable): Boolean {
        return !(str.isEmpty() && dex.isEmpty() && cons.isEmpty() && intel.isEmpty() && wis.isEmpty() && char.isEmpty())
    }
}