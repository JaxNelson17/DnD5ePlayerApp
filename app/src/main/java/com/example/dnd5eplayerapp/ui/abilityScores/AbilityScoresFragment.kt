package com.example.dnd5eplayerapp.ui.abilityScores

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.database.Character
import kotlinx.android.synthetic.main.ab_scores_fragment.*
import kotlinx.android.synthetic.main.ab_scores_fragment.characterClass
import kotlinx.android.synthetic.main.ab_scores_fragment.view.*

class AbilityScoresFragment : Fragment() {

    private lateinit var viewModel: AbiltyScoresViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflates the View
        val view = inflater.inflate(R.layout.ab_scores_fragment, container,false)

        viewModel = ViewModelProvider(this).get(AbiltyScoresViewModel::class.java)

        view.add_character_btn.setOnClickListener {
            insertDataToDatabase()
            findNavController().navigate(R.id.characterListFragment)
        }

        return view
    }

    private fun insertDataToDatabase() {
        val name = characterNameText.text.toString()
        val _class = characterClass.text.toString()
        val str = strText.text
        val dex= dexText.text
        val cons = consText.text
        val intel = intelText.text
        val wis = wisText.text
        val char = charText.text
        val lvl = levelText.text

        if (inputCheck(name, _class, str, dex, cons, intel, wis, char, lvl)) {
            // Creates the Character Object
            val character = Character(0, name, _class, Integer.parseInt(str.toString()), Integer.parseInt(dex.toString()), Integer.parseInt(cons.toString()), Integer.parseInt(intel.toString()), Integer.parseInt(wis.toString()), Integer.parseInt(char.toString()), Integer.parseInt(lvl.toString()))
            // Adds the Data to the Database
            viewModel.addCharacter(character)
            Toast.makeText(requireContext(), "Added in!!", Toast.LENGTH_LONG).show()
        } else {
            // Makes sure that you filled up field
            Toast.makeText(requireContext(), "Didn't work", Toast.LENGTH_LONG).show()
        }
    }

    // Function to make sure that the fields are empty or not
    private fun inputCheck(name: String, clas: String, str: Editable, dex: Editable, cons: Editable, intel: Editable, wis: Editable, char: Editable, lvl: Editable): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(clas) && str.isEmpty() && dex.isEmpty() && cons.isEmpty() && intel.isEmpty() && wis.isEmpty() && char.isEmpty() && lvl.isEmpty())
    }
}