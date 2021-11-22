package com.example.dnd5eplayerapp.ui.infoScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.InfoScreenBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.coroutines.launch

class InfoFragment : Fragment() {

    private lateinit var viewModel: InfoViewModel
    private lateinit var binding: InfoScreenBinding

    private val callback = OnMapReadyCallback { googleMap ->
        viewLifecycleOwner.lifecycleScope.launch {
            val zoom = 13.0F

            val target = LatLng(37.098531, -113.5916404)
            val targetWindow = LatLng(37.05, -113.5916404)
            googleMap.addMarker(target.let { MarkerOptions().position(it).title(target.toString()) })
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(targetWindow))
            googleMap.animateCamera(CameraUpdateFactory.zoomTo(zoom))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.info_screen, container, false)

        val application = requireNotNull(this.activity).application
        val viewModelFactory = InfoViewModelFactory(application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(InfoViewModel::class.java)

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.mainMenuFragment)
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}