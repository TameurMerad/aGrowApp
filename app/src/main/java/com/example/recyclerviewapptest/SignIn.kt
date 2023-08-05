package com.example.recyclerviewapptest

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR


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
            finish()
        }

        signin.setOnClickListener(){
            val name = userNameTv.text.toString()
            val email = emailTv.text.toString()
            val password = passowrdTv.text.toString()
            if (name.isEmpty() || email.isEmpty() ||password.isEmpty()){
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
                firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                    if (it.isSuccessful){
                        startActivity(Intent(this, MainActivity::class.java))
//                        Toast.makeText(this, "bsa7tk u registred", Toast.LENGTH_SHORT).show()

                    } else  {
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