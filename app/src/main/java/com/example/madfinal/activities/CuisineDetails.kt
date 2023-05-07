package com.example.madfinal.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madfinal.R
import com.google.firebase.database.FirebaseDatabase

class CuisineDetails : AppCompatActivity() {

        private lateinit var tvMenuID: TextView
        private lateinit var tvMenuName: TextView
        private lateinit var tvPostedOn: TextView
        private lateinit var tvExpiredOn: TextView
        private lateinit var tvIngredients: TextView
        private lateinit var tvMealType: TextView
        private lateinit var updateBTN : Button
        private lateinit var deleteBTN : Button

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_book_details)

            initView()
            setValuesToViews()

            deleteBTN.setOnClickListener {
                deleteRecord(
                    intent.getStringExtra("menuId").toString()
                )
            }
        }

        private fun deleteRecord(
            tvBookID: String
        ){
            val dbRef = FirebaseDatabase.getInstance().getReference("Menus").child(tvMenuID.toString())
            val mTask = dbRef.removeValue()

            mTask.addOnSuccessListener {
                Toast.makeText(this, "Saved data deleted", Toast.LENGTH_LONG).show()

                val intent = Intent(this, Fetch::class.java)
                finish()
                startActivity(intent)
            }.addOnFailureListener{ error ->
                Toast.makeText(this, "Deleting Err ${error.message}", Toast.LENGTH_LONG).show()
            }
        }


        private fun initView() {
            tvMenuID = findViewById(R.id.tvMenuId)
            tvMenuName = findViewById(R.id.tvMenuName)
            tvPostedOn = findViewById(R.id.tvPostedOn)
            tvExpiredOn = findViewById(R.id.tvExpiredOn)
            tvIngredients = findViewById(R.id.tvIngredients)
            tvMealType = findViewById(R.id.tvMealType)
            updateBTN = findViewById(R.id.btnUpdate)
            deleteBTN = findViewById(R.id.btnDelete)
        }

        private fun setValuesToViews(){
            tvMenuID.text = intent.getStringExtra("menuId")
            tvMenuName.text = intent.getStringExtra("menuName")
            tvPostedOn.text = intent.getStringExtra("postedOn")
            tvExpiredOn.text = intent.getStringExtra("expiredOn")
            tvIngredients.text = intent.getStringExtra("ingredients")
            tvMealType.text = intent.getStringExtra("mealType")
        }
}
