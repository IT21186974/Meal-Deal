package com.example.mealdealapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mealdealapp.db.BreakfastMenu
import com.example.mealdealapp.db.BreakfastMenuDataBase

class BreakfastActivity : AppCompatActivity() {


//    private lateinit var btnBack: Button
    private lateinit var edItem : EditText
    private lateinit var edPrice: EditText
    private lateinit var btnSave: Button
    private lateinit var btnClear: Button

    private lateinit var viewModel: BreakfastMenuViewModel
    private lateinit var breakfastMenuRecyclerView: RecyclerView
    private lateinit var adapter: BreakfastMenuRecyclerViewAdapter
    private var isListItemClicked = false

    private lateinit var selectedBreakfastMenu: BreakfastMenu


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breakfast)

        edItem = findViewById(R.id.edItem)
        edPrice = findViewById(R.id.edPrice)
        btnSave = findViewById(R.id.btnSave)
        btnClear = findViewById(R.id.btnClear)
//        btnBack = findViewById(R.id.btnback)
        breakfastMenuRecyclerView = findViewById(R.id.rvBreakfastMenu)

        val dao = BreakfastMenuDataBase.getInstance(application).breakfastMenuDao()
        val factory = BreakfastMenuViewModelFactory(dao)
        viewModel = ViewModelProvider(this, factory).get(BreakfastMenuViewModel::class.java)

        btnSave.setOnClickListener {
            if (isListItemClicked) {
                updateBreakfastMenuData()
                clearInput()

            } else {
                saveBreakfastMenuData()
                clearInput()
            }
        }
        btnClear.setOnClickListener {
            if (isListItemClicked) {
                deleteBreakfastMenuData()
                clearInput()
            } else {
            }
            clearInput()
        }

        initRecyclerView()
//        btnBack.setOnClickListener {
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun saveBreakfastMenuData(){
        viewModel.insertBreakFastMenu(
            BreakfastMenu(
                0,
                edItem.text.toString(),
                edPrice.text.toString()
            )
        )
    }

    private fun updateBreakfastMenuData(){
        viewModel.updateBreakFastMenu(
            BreakfastMenu(
                selectedBreakfastMenu.id,
                edItem.text.toString(),
                edPrice.text.toString()
            )
        )

        btnSave.text = "Save"
        btnClear.text = "Clear"
        isListItemClicked = false
    }

    private fun deleteBreakfastMenuData(){
        viewModel.deleteBreakFastMenu(
            BreakfastMenu(
                selectedBreakfastMenu.id,
                edItem.text.toString(),
                edPrice.text.toString()
            )
        )

        btnSave.text = "Save"
        btnClear.text = "Clear"
        isListItemClicked = false
    }
    private fun clearInput(){
        edItem.setText("")
        edPrice.setText("")
    }

    private fun initRecyclerView(){

        breakfastMenuRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = BreakfastMenuRecyclerViewAdapter{
            selectedItem:BreakfastMenu ->listItemClicked(selectedItem)
        }
        breakfastMenuRecyclerView.adapter = adapter

        displayBreakfastMenusList()
    }

    private fun displayBreakfastMenusList(){
        viewModel.breakfastMenus.observe(this, {
            adapter.setList(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun listItemClicked(breakfastMenu: BreakfastMenu){
//        Toast.makeText(
//            this,
//            "Breakfast Menu item is ${breakfastMenu.item}",
//            Toast.LENGTH_SHORT
//        ).show()

        selectedBreakfastMenu = breakfastMenu
        btnSave.text = "Update"
        btnClear.text = "Delete"
        isListItemClicked = true

        edItem.setText(selectedBreakfastMenu.item)
        edPrice.setText(selectedBreakfastMenu.price)

    }



}









