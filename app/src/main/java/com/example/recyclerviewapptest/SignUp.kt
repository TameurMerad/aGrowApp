package com.example.recyclerviewapptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)



        val firebaseAuth = FirebaseAuth.getInstance()


        val emailLogin = findViewById<EditText>(R.id.emailLoginET)
        val passwordLogin = findViewById<EditText>(R.id.passowrdLoginTV)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        findViewById<TextView>(R.id.registerBtnTV).setOnClickListener(){
            startActivity(Intent(this, SignIn::class.java))
        }
        loginBtn.setOnClickListener(){
            val email = emailLogin.text.toString()
            val passowrd = passwordLogin.text.toString()
            if (email.isEmpty()||passowrd.isEmpty()) {
                Toast.makeText(this, "Empty fields are not required", Toast.LENGTH_SHORT).show()
            }else {
                firebaseAuth.signInWithEmailAndPassword(email , passowrd).addOnCompleteListener{
                    if (it.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
//                        Toast.makeText(this, "Bsahtk you're in", Toast.LENGTH_SHORT).show()
                    } else{
                        Toast.makeText(this, "there is a problem", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }



    }
}