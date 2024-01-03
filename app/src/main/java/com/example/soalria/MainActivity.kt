package com.example.soalria

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.example.soalria.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //hide title bar
        getSupportActionBar()?.hide()

        //instance
        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView);

        //set fragment
        val aboutFragment=AboutFragment()
        val menuFragment=MenuFragment()
        val ratefragment=RateFragment()
        val accFragment = AccFragment();
        val homeFragment = HomeFragment();

        //default fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,homeFragment)
            commit()
        }

        currentFragment(homeFragment)



        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.fragmentHome->currentFragment(homeFragment)
                R.id.fragmentAbout->currentFragment(aboutFragment)
                R.id.fragmentMenu->currentFragment(menuFragment)
                R.id.fragmentRate->currentFragment(ratefragment)
                R.id.fragmentAccount->currentFragment(accFragment)
            }
            true
        }


        //currentFragment(homeFragment)

        /*default fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,homeFragment)
            commit()
        }

        currentFragment(homeFragment)

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.fragmentAbout->currentFragment(aboutFragment)
                R.id.fragmentMenu->currentFragment(menuFragment)
                R.id.fragmentHome->currentFragment(homeFragment)
                R.id.fragmentRate->currentFragment(ratefragment)
                R.id.fragmentAccount->currentFragment(accFragment)
            }
            true
        }*/
    }

    private fun currentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,fragment)
            commit()
        }
}