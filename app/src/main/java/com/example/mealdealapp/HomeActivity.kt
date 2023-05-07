package com.example.mealdealapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val breakfast = findViewById<CardView>(R.id.cardBreakfast)
        breakfast.setOnClickListener {
            startActivity(
                Intent(
                    this@HomeActivity,
                    BreakfastActivity::class.java
                )
            )
        }

        val lunch = findViewById<CardView>(R.id.cardLunch)
        lunch.setOnClickListener {
            val it = Intent(this@HomeActivity, LunchActivity::class.java)
            it.putExtra("title","Lunch Menu")
            startActivity(it)
        }

        val dinner = findViewById<CardView>(R.id.cardDinner)
        dinner.setOnClickListener {
            val it = Intent(this@HomeActivity,DinnerActivity::class.java)
            it.putExtra("title","Dinner Menu")
            startActivity(it)
        }

        val profile = findViewById<CardView>(R.id.cardProfile)
        profile.setOnClickListener {
            val it = Intent(this@HomeActivity,ProfileActivity::class.java)
            it.putExtra("title","My Profile")
            startActivity(it)
        }
    }
}