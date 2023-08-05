package com.example.recyclerviewapptest

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


        val firebaseAuth = FirebaseAuth.getInstance()


        val emailLogin = findViewById<EditText>(R.id.emailLoginET)
        val passwordLogin = findViewById<EditText>(R.id.passowrdLoginTV)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        findViewById<TextView>(R.id.registerBtnTV).setOnClickListener(){
            startActivity(Intent(this, SignIn::class.java))
            finish()
        }
        loginBtn.setOnClickListener(){
            val email = emailLogin.text.toString()
            val passowrd = passwordLogin.text.toString()
            if (email.isEmpty()||passowrd.isEmpty()) {
//                Toast.makeText(this, "Empty fields are not required", Toast.LENGTH_SHORT).show()


                val dialogBinding = layoutInflater.inflate(R.layout.no_empty_popup, null)
                val myDialog = Dialog(this)
                myDialog.setContentView(dialogBinding)
                myDialog.setCancelable(true)
                myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                myDialog.show()
                dialogBinding.findViewById<Button>(R.id.okBTN).setOnClickListener(){
                    myDialog.dismiss()
                }


            }else {
                firebaseAuth.signInWithEmailAndPassword(email , passowrd).addOnCompleteListener{
                    if (it.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
//                        Toast.makeText(this, "Bsahtk you're in", Toast.LENGTH_SHORT).show()
                    } else{
//                        Toast.makeText(this, "there is a problem", Toast.LENGTH_SHORT).show()
                        val dialogBinding = layoutInflater.inflate(R.layout.sign_in_popup, null)
                        val myDialog = Dialog(this)
                        myDialog.setContentView(dialogBinding)
                        myDialog.setCancelable(true)
                        myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                        myDialog.show()
                        dialogBinding.findViewById<Button>(R.id.tryagainBTN).setOnClickListener(){
                            myDialog.dismiss()
                        }
                        dialogBinding.findViewById<Button>(R.id.skipBtn).setOnClickListener(){
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()

                        }
                    }
                }
            }
        }



    }
}