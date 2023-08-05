package com.example.recyclerviewapptest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)



        val firebaseAuth = FirebaseAuth.getInstance()


        val items = listOf("Farmer", "Expert", "investor")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        findViewById<AutoCompleteTextView>(R.id.autoCompleteV).setAdapter(adapter)

        val userNameTv = findViewById<EditText>(R.id.nameSignInET)
        val emailTv = findViewById<EditText>(R.id.emailSignInET)
        val passowrdTv = findViewById<EditText>(R.id.passowrdSigninTV)
        val signin = findViewById<Button>(R.id.SignInBtn)
        val toSignUp = findViewById<TextView>(R.id.SignUpBtnTV)

        toSignUp.setOnClickListener(){
            startActivity(Intent(this, SignUp::class.java))
        }

        signin.setOnClickListener(){
            val name = userNameTv.text.toString()
            val email = emailTv.text.toString()
            val password = passowrdTv.text.toString()
            if (name.isEmpty() || email.isEmpty() ||password.isEmpty()){
                Toast.makeText(this, "Empty fields are not required", Toast.LENGTH_SHORT).show()
            }else {
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
//                        Toast.makeText(this, "bsa7tk u registred", Toast.LENGTH_SHORT).show()

                    } else  { Toast.makeText(this, "there is a problem", Toast.LENGTH_SHORT).show() }
                }
            }
        }




    }
}