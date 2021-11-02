package com.example.dnd5eplayerapp.ui.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            navigateToFragment()
        }

        return view
    }

    private fun navigateToFragment() {
        parentFragmentManager.commit {
            replace<AbilityScoresFragment>(R.id.nav_host_fragment)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }
}