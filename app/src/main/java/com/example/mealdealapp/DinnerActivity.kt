package com.example.mealdealapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class DinnerActivity : AppCompatActivity() {

    private lateinit var textView7: TextView
    private lateinit var button6: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dinner)

        textView7 = findViewById(R.id.textView7)
        button6 = findViewById(R.id.button6)

        button6.setOnClickListener {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }





    }
}