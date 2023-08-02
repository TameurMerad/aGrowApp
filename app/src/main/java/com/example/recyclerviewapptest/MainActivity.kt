package com.example.recyclerviewapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFrag())
    }

    private fun replaceFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.flFrsgment , fragment).commit()
    }


}