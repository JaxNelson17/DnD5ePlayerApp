package com.example.dnd5eplayerapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.dnd5eplayerapp.ui.home.HomeFragment
import com.example.dnd5eplayerapp.ui.mainMenu.MainMenuFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val home = HomeFragment()
        val menu = MainMenuFragment()

        makeCurrentFragment(menu)

        bottom_nav_bar.setOnItemSelectedListener {
            when (it) {
                R.id.navigation_home -> makeCurrentFragment(menu)
                R.id.navigation_menu -> makeCurrentFragment(home)
            }
        }

    }
    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, fragment)
            commit()
        }
}