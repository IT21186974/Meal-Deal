package com.example.mealdealapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextTextPerson: EditText
    private lateinit var editTextTextPassword: EditText
    private lateinit var button2: Button
    private lateinit var buttonRegister: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextTextPerson = findViewById(R.id.editTextTextPersonName)
        editTextTextPerson = findViewById(R.id.editTextTextPassword)
        button2 = findViewById(R.id.button2)
        buttonRegister = findViewById(R.id.buttonRegister)

        buttonRegister.setOnClickListener{
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent (this, HomeActivity::class.java)
            startActivity(intent)
        }

        }

    }

