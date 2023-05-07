package com.example.madfinal.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.madfinal.R
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

//        private lateinit var image: ImageButton
        private lateinit var myOrders: Button
        private lateinit var insertBTN: Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val firebase : DatabaseReference = FirebaseDatabase.getInstance().getReference()

//            image = findViewById(R.id.img_btn)
            myOrders = findViewById(R.id.ordersBTN)
            insertBTN = findViewById(R.id.insertBTN)

//            image.setOnClickListener{
//                val intent = Intent(this, Insert::class.java)
//                startActivity(intent)
//            }
            myOrders.setOnClickListener{
                val intent = Intent(this, Fetch::class.java)
                startActivity(intent)
            }
            insertBTN.setOnClickListener {
                val intent = Intent(this, Insert::class.java)
                startActivity(intent)
            }

        }
}