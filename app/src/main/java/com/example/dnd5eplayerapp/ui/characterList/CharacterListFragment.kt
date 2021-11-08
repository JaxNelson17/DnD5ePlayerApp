package com.example.dnd5eplayerapp.ui.characterList

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.ui.abilityScores.AbilityScoresFragment
import com.example.dnd5eplayerapp.ui.abilityScores.AbilityScoresViewModelFactory
import com.example.dnd5eplayerapp.ui.abilityScores.AbiltyScoresViewModel
import com.example.dnd5eplayerapp.ui.characterCreation.CreationViewModel
import com.example.dnd5eplayerapp.ui.characterDetail.DetailFragment
import kotlinx.android.synthetic.main.character_list_fragment.view.*
import kotlinx.android.synthetic.main.character_list_view_item.view.*

class CharacterListFragment: Fragment() {

    private lateinit var viewModel: AbiltyScoresViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.character_list_fragment, container, false)

        // Recyclerview
        val adapter = CharacterListAdapter()
        val recyclerView = view.listRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // ViewModel
        viewModel = ViewModelProvider(this).get(AbiltyScoresViewModel::class.java)
        viewModel.readAllData.observe(viewLifecycleOwner, Observer { character ->
            adapter.setData(character)
        })

        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.abilityScoresFragment)
        }

        view.floatingActionButton2.setOnClickListener {
            findNavController().navigate(R.id.mainMenuFragment)
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAllUsers()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllUsers() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") { _, _ ->
            viewModel.deleteAllCharacters()
            Toast.makeText(requireContext(), "Deleted Everything", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure you want to delete everything?")
        builder.create().show()
    }
}