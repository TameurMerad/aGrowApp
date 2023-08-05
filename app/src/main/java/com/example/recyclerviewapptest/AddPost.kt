package com.example.recyclerviewapptest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.ImageView

class AddPost : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)
        val items = listOf("Search for consulting", "Project Idea", "Investment","Problem","Other")
        val adapter = ArrayAdapter(this, R.layout.list_item, items)
        findViewById<AutoCompleteTextView>(R.id.postAutoCompleteV).setAdapter(adapter)
        findViewById<ImageView>(R.id.backBtn).setOnClickListener(){
            onBackPressed()
        }
        findViewById<Button>(R.id.addPostBtn).setOnClickListener(){
            onBackPressed()
        }



    }
}