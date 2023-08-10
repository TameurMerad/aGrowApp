package com.example.recyclerviewapptest

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class UserFrag : Fragment (){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user, container, false)
        val posts = view.findViewById<Button>(R.id.profilBtnPosts)
        val contact = view.findViewById<Button>(R.id.profilBtnContact)
        val experience = view.findViewById<Button>(R.id.profilBtnExperience)
        val picChange = view.findViewById<ImageView>(R.id.profilPicChange)
        val profilPic = view.findViewById<ImageView>(R.id.profilPic)

        replaceFragment(ProfilExperienceFrag())


        picChange.setOnClickListener(){
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
            }


        }




        posts.setOnClickListener(){
            posts.setBackgroundResource(R.drawable.profil_btns_selected)
            replaceFragment(ProfilPostsFrag())
            contact.setBackgroundResource(R.drawable.profil_btns)
            experience.setBackgroundResource(R.drawable.profil_btns)
        }
        contact.setOnClickListener(){
            contact.setBackgroundResource(R.drawable.profil_btns_selected)
            replaceFragment(ProfilContactFrag())
            posts.setBackgroundResource(R.drawable.profil_btns)
            experience.setBackgroundResource(R.drawable.profil_btns)
        }
        experience.setOnClickListener(){
            experience.setBackgroundResource(R.drawable.profil_btns_selected)
            replaceFragment(ProfilExperienceFrag())
            posts.setBackgroundResource(R.drawable.profil_btns)
            contact.setBackgroundResource(R.drawable.profil_btns)
        }



        return view
    }
    private fun replaceFragment (fragment: Fragment){
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.profilFlFrag , fragment).commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
            if (resultCode == Activity.RESULT_OK && requestCode == 0){

                val uri = data?.data
               requireActivity().findViewById<ImageView>(R.id.profilPic).setImageURI(uri)
            }

    }

    }