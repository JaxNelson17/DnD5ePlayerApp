package com.example.dnd5eplayerapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.HomeFragmentBinding
import com.example.dnd5eplayerapp.repository.Repository
import kotlinx.coroutines.CoroutineScope

class HomeFragment() : Fragment()  {

    private lateinit var homeViewModel: HomeViewModel
    private val myAdapter by lazy { HomeAdapter() }
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)

        val repository = Repository()
        val viewModelFactory = HomeViewModelFactory(repository)

        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        homeViewModel.getCustomData("")

        homeViewModel.myCustomData.observe(viewLifecycleOwner, Observer { response ->
            myAdapter.submitList(response)
        })

        binding.recyclerView.adapter = myAdapter

        return binding.root
    }

}