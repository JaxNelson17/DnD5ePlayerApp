package com.example.dnd5eplayerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.dnd5eplayerapp.ui.characterCreation.CreationFragment
import com.example.dnd5eplayerapp.ui.home.HomeFragment
import com.example.dnd5eplayerapp.ui.mainMenu.MainMenuFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val home = HomeFragment()
        val menu = MainMenuFragment()
        val info = CreationFragment()

        makeCurrentFragment(home)

        bottom_nav_bar.setOnItemSelectedListener {
            when (it) {
                R.id.homeFragment -> makeCurrentFragment(home)
                R.id.menuFragment -> makeCurrentFragment(menu)
                R.id.creationFragment -> makeCurrentFragment(info)
            }
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, fragment)
            commit()
        }
}