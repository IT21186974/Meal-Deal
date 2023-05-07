package com.example.mealdealapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BreakfastActivity : AppCompatActivity() {

    private lateinit var textView9: TextView
    private lateinit var btnBack: Button
    private lateinit var edID : EditText
    private lateinit var edItem: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnDelete: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast)

        textView9 = findViewById(R.id.textView9)
        btnBack = findViewById(R.id.btnback)

        btnBack.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}