package com.example.recyclerviewapptest

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.WindowDecorActionBar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager


class homeFrag : Fragment () {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_home, container, false)
        val showPopUp1 = popUpFrag()
        val showPopUp2 = popUpFragTwo()



        requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

           view.findViewById<TextView>(R.id.followBtn).setOnClickListener(){
               view.findViewById<TextView>(R.id.followBtn).text = "Followed"
           }
        view.findViewById<TextView>(R.id.followBtn2).setOnClickListener(){
            view.findViewById<TextView>(R.id.followBtn2).text = "Followed"
        }
        view.findViewById<TextView>(R.id.followBtn3).setOnClickListener(){
            view.findViewById<TextView>(R.id.followBtn3).text = "Followed"
        }
        view.findViewById<TextView>(R.id.followBtn4).setOnClickListener(){
            view.findViewById<android.widget.TextView>(com.example.recyclerviewapptest.R.id.followBtn4).text = "Followed"
        }









        view.findViewById<TextView>(R.id.helpBtn1).setOnClickListener(){
//            Toast.makeText(activity, "the first Contact Clicked", Toast.LENGTH_SHORT).show()
            showPopUp1.show((activity as AppCompatActivity).supportFragmentManager, "showPopUp")

        }
        view.findViewById<TextView>(R.id.helpBtn2).setOnClickListener(){
//            Toast.makeText(activity, "the second Contact Clicked", Toast.LENGTH_SHORT).show()
            showPopUp2.show((activity as AppCompatActivity).supportFragmentManager, "showPopUp")

        }
        view.findViewById<TextView>(R.id.helpBtn3).setOnClickListener(){
//            Toast.makeText(activity, "the third Contact Clicked", Toast.LENGTH_SHORT).show()
            showPopUp1.show((activity as AppCompatActivity).supportFragmentManager, "showPopUp")

        }
        view.findViewById<TextView>(R.id.helpBtn4).setOnClickListener(){
//            Toast.makeText(activity, "the fourth Contact Clicked", Toast.LENGTH_SHORT).show()
            showPopUp2.show((activity as AppCompatActivity).supportFragmentManager, "showPopUp")

        }




        return view
    }

}

//
//requireActivity().window.statusBarColor = Color.WHITE
//requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR