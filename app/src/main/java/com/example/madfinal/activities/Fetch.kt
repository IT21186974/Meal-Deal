package com.example.madfinal.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.madfinal.R
import com.example.madfinal.adapters.Cuisine_Adapter
import com.example.madfinal.models.Cuisine_Model
import com.google.firebase.database.*

class Fetch : AppCompatActivity() {

        private lateinit var menuRecyclerView: RecyclerView
        private lateinit var loadingData: TextView
        private lateinit var menuList:ArrayList<Cuisine_Model>
        private lateinit var dbRef: DatabaseReference

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_fetching)

            menuRecyclerView = findViewById(R.id.rvMenu)
            menuRecyclerView.layoutManager = LinearLayoutManager(this)
            menuRecyclerView.setHasFixedSize(true)
            loadingData = findViewById(R.id.tvLoadingData)

            menuList = arrayListOf()

            getMenuData()
        }

        private fun getMenuData(){
            menuRecyclerView.visibility = View.GONE
            loadingData.visibility = View.VISIBLE

            dbRef = FirebaseDatabase.getInstance().getReference("menus")

            dbRef.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    menuList.clear()
                    if (snapshot.exists()){
                        for (menuSnap in snapshot.children){
                            val menuData = menuSnap.getValue(Cuisine_Model::class.java)
                            menuList.add(menuData!!)
                        }
                        val mAdapter = Cuisine_Adapter(menuList)
                        menuRecyclerView.adapter = mAdapter

                        mAdapter.setOnItemClickListener(object : Cuisine_Adapter.OnItemClickListener{
                            override fun onItemClick(position: Int) {
                                val intent = Intent(this@Fetch, CuisineDetails::class.java)

                                //put extras
                                intent.putExtra("menuId", menuList[position].menuID)
                                intent.putExtra("menuName", menuList[position].menu_name)
                                intent.putExtra("price", menuList[position].price)
                                intent.putExtra("postedOn", menuList[position].posted_on)
                                intent.putExtra("expiredOn", menuList[position].expired_on)
                                intent.putExtra("ingredients", menuList[position].ingredients)
                                intent.putExtra("menuType", menuList[position].meal_type)
                                startActivity(intent)
                            }

                        })
                        menuRecyclerView.visibility = View.VISIBLE
                        loadingData.visibility = View.GONE

                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
        }
    }