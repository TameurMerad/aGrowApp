package com.example.recyclerviewapptest

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.onboarding.secFrag
import com.example.onboarding.thirdFrag

class ViewPagerAdapter(fragmentManager: FragmentManager) :FragmentPagerAdapter (fragmentManager){
    private val fragments = listOf(
        firstFrag(),
        secFrag(),
        thirdFrag()
    )

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

}