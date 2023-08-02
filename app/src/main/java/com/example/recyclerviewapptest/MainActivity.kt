package com.example.recyclerviewapptest

import android.graphics.Color
import android.os.Bundle
import android.view.MenuItem
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.recyclerviewapptest.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        replaceFragment(homeFrag())

        findViewById<BottomNavigationView>(R.id.btmNavBar).setOnItemSelectedListener {
        when(it.itemId){
            R.id.miSearch -> replaceFragment(SearchFrag())
            R.id.miHome -> replaceFragment(homeFrag())
            R.id.miUser -> replaceFragment(UserFrag())
            R.id.miShopping -> replaceFragment(ShopFrag())
          else -> {}
        }
           true
        }


    }

    private fun replaceFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flFrsgment , fragment).commit()
    }


}