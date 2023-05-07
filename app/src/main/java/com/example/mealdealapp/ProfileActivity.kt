package com.example.mealdealapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {


    private lateinit var txtProfile: TextView
    private lateinit var btnBack6: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        txtProfile = findViewById(R.id.txtProfile)
        btnBack6 = findViewById(R.id.btnback6)

        btnBack6.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}