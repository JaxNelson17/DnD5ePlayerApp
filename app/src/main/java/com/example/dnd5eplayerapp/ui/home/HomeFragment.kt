package com.example.dnd5eplayerapp.ui.home

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.databinding.HomeFragmentBinding
import com.example.dnd5eplayerapp.repository.Repository
import kotlinx.android.synthetic.main.creation_fragment.*
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_recyclerview_item.*
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
        binding.random.setOnClickListener {
            val myMonster = monsterEditText.text.toString().toLowerCase()

            homeViewModel.getMonsters(myMonster)
            homeViewModel.myCustomMonster.observe(viewLifecycleOwner, Observer { response ->
                if (response.isSuccessful) {

                    strMonster.text = response.body()?.strength.toString()
                    dexMonster.text = response.body()?.dexterity.toString()
                    consMonster.text = response.body()?.constitution.toString()
                    intelMonster.text = response.body()?.intelligence.toString()
                    wisMonster.text = response.body()?.wisdom.toString()
                    charMonster.text = response.body()?.charisma.toString()

                    monsName.text = response.body()?.name.toString()
                    monsType.text = response.body()?.type.toString()
                    monsSubType.text = response.body()?.subtype.toString()

                    monsArmor.text = response.body()?.armorClass.toString()
                    monsHit.text = response.body()?.hitPoints.toString()
                    monsHitDice.text = response.body()?.hitDice.toString()
                    action.text = response.body()?.actions.toString()
                    action.movementMethod = ScrollingMovementMethod()
                } else {
                    Log.i("Monster", "Your monster is blank")
                }
            })
        }

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.mainMenuFragment)
        }


        return binding.root
    }

}