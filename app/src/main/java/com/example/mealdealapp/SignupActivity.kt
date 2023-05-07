package com.example.mealdealapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SignupActivity : AppCompatActivity() {

    private lateinit var editTextTextPerson2: EditText
    private lateinit var editTextTextEmailAddress: EditText
    private lateinit var editTextTextPassword2: EditText
    private lateinit var editTextTextPassword3: EditText
    private lateinit var button: Button
    private lateinit var textView4 : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        editTextTextPerson2 = findViewById(R.id.editTextTextPersonName2)
        editTextTextEmailAddress = findViewById((R.id.editTextTextEmailAddress))
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2)
        editTextTextPassword3 = findViewById(R.id.editTextTextPassword3)
        button = findViewById(R.id.button)
        textView4 = findViewById(R.id.textView4)

        button.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        textView4.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }
}