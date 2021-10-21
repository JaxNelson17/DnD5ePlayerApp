package com.example.dnd5eplayerapp.ui.home

//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import com.example.dnd5eplayerapp.R
//import com.example.dnd5eplayerapp.databinding.HomeFragmentBinding
//import androidx.databinding.DataBindingUtil
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class HomeFragment() : Fragment() {
//
//    private lateinit var homeViewModel: HomeViewModel
//    private lateinit var binding: HomeFragmentBinding
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var adapter: HomeAdapter
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        binding = DataBindingUtil.inflate(
//            inflater, R.layout.home_fragment, container, false
//        )
//
//        val application = requireNotNull(this.activity).application
//
//        val viewModelFactory = HomeViewModelFactory(application)
//        homeViewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
//
//        binding.homeViewModel = homeViewModel
//        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//
//
//        recyclerView.adapter = adapter
//
//        return binding.root
//    }
//}