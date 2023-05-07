package com.example.madfinal.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madfinal.R
import com.example.madfinal.models.Cuisine_Model
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Insert : AppCompatActivity() {

        private lateinit var backButton: Button

        private lateinit var menuName__: EditText
        private lateinit var price_: EditText
        private lateinit var postedOn_: EditText
        private lateinit var expiredOn_: EditText
        private lateinit var ingredients_: EditText
        private lateinit var mealType_: EditText
        private lateinit var confirmSaveBTN_: Button

        private lateinit var dbRef: DatabaseReference

        //@SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_insertion)

            backButton = findViewById(R.id.back_btn)

            backButton.setOnClickListener{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }

            menuName__ = findViewById(R.id.menuName_)
            price_ = findViewById(R.id.price)

            postedOn_ = findViewById(R.id.postedOn)
            expiredOn_ = findViewById(R.id.expiredOn)
            ingredients_ = findViewById(R.id.ingredients)
            mealType_ = findViewById(R.id.mealType)
            confirmSaveBTN_ = findViewById(R.id.confirmSaveBTN)

            dbRef = FirebaseDatabase.getInstance().getReference("Menus")

            confirmSaveBTN_.setOnClickListener{
                saveMenuDetails()
            }
        }


        private fun saveMenuDetails(){

            val menuName = menuName__.text.toString()
            val price = price_.text.toString()

            val postedOn = postedOn_.text.toString()
            val expiredOn = expiredOn_.text.toString()
            val ingredients = ingredients_.text.toString()
            val mealType = mealType_.text.toString()

            if (postedOn.isEmpty()){
                postedOn_.error = "Please enter date"
            }
            if (expiredOn.isEmpty()){
                expiredOn_.error = "Please enter expiry date"
            }
            if (ingredients.isEmpty()){
                ingredients_.error = "Please enter the ingredients"
            }
            if (mealType.isEmpty()){
                mealType_.error = "Please enter meal type"
            }
            if (menuName.isEmpty()){
                menuName__.error = "Please enter menu name"
            }
            if (price.isEmpty()){
                price_.error = "Please enter price"
            }

            val menuID = dbRef.push().key!!

            val menu = Cuisine_Model(menuID,menuName,price,postedOn,expiredOn,ingredients, mealType )

            dbRef.child(menuID).setValue(menu)
                .addOnCompleteListener{
                    Toast.makeText(this,"Data inserted successfully", Toast.LENGTH_LONG).show()

                    postedOn_.text.clear()
                    expiredOn_.text.clear()
                    ingredients_.text.clear()
                    mealType_.text.clear()
                    menuName__.text.clear()
                    price_.text.clear()

                }.addOnFailureListener{
                    Toast.makeText(this,"Error", Toast.LENGTH_LONG).show()
                }.addOnFailureListener { err ->
                    Toast.makeText(this, "Error ${err.message}", Toast.LENGTH_LONG).show()
                }



        }
}