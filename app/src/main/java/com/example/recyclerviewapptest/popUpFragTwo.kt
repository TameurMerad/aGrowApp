package com.example.recyclerviewapptest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class popUpFragTwo : DialogFragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_pop_up_frag_two, container, false)

        view.findViewById<Button>(R.id.cancelBtn).setOnClickListener(){
            dismiss()
        }
        view.findViewById<Button>(R.id.contributeBTN).setOnClickListener(){
            dismiss()
        }



        return view
    }


}
