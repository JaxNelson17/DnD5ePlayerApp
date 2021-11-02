package com.example.dnd5eplayerapp.ui.characterDetail

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.ui.abilityScores.AbiltyScoresViewModel
import com.example.dnd5eplayerapp.ui.characterList.CharacterListFragment
import kotlinx.android.synthetic.main.ab_scores_fragment.*
import kotlinx.android.synthetic.main.character_detail_fragment.*
import kotlinx.android.synthetic.main.character_detail_fragment.view.*

class DetailFragment : Fragment() {


    private lateinit var viewModel: AbiltyScoresViewModel
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.character_detail_fragment, container, false)

        viewModel = ViewModelProvider(this).get(AbiltyScoresViewModel::class.java)

        view.strUpdate.setText(args.currentCharacter.strength.toString())
        view.dexUpdate.setText(args.currentCharacter.dexterity.toString())
        view.consUpdate.setText(args.currentCharacter.constitution.toString())
        view.intelUpdate.setText(args.currentCharacter.intelligence.toString())
        view.wisUpdate.setText(args.currentCharacter.wisdom.toString())
        view.charUpdate.setText(args.currentCharacter.charisma.toString())

        view.update_character_btn.setOnClickListener {
            updateCharacter()
        }

        // add menu
        setHasOptionsMenu(true)

        return view

    }

    private fun updateCharacter() {
        val str = Integer.parseInt(strUpdate.text.toString())
        val dex= Integer.parseInt(dexUpdate.text.toString())
        val cons = Integer.parseInt(consUpdate.text.toString())
        val intel = Integer.parseInt(intelUpdate.text.toString())
        val wis = Integer.parseInt(wisUpdate.text.toString())
        val char = Integer.parseInt(charUpdate.text.toString())

        if (inputCheck(strUpdate.text, dexUpdate.text, consUpdate.text, intelUpdate.text, wisUpdate.text, charUpdate.text)) {
            // Create User Object
            val updatedCharacter = Character(args.currentCharacter.id, str, dex, cons, intel, wis, char)
            // Update Current Character
            viewModel.updateCharacter(updatedCharacter)
            Toast.makeText(requireContext(), "Successfully Updated!", Toast.LENGTH_SHORT).show()
            // Navigate back
            findNavController().navigate(R.id.action_homeFragment_to_characterListFragment)
        } else {
            Toast.makeText(requireContext(), "Didn't update, fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(str: Editable, dex: Editable, cons: Editable, intel: Editable, wis: Editable, char: Editable): Boolean {
        return !(str.isEmpty() && dex.isEmpty() && cons.isEmpty() && intel.isEmpty() && wis.isEmpty() && char.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteCharacter()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteCharacter() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteCharacter(args.currentCharacter)
            Toast.makeText(requireContext(), "Successfully Deleted", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_homeFragment_to_characterListFragment)

        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete ${args.currentCharacter.strength}?")
        builder.setMessage("Are you sure you want to delete ${args.currentCharacter.strength}?")
        builder.create().show()
    }

}