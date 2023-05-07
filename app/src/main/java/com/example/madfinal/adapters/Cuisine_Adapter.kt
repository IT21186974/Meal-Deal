package com.example.madfinal.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.madfinal.R
import com.example.madfinal.models.Cuisine_Model

class Cuisine_Adapter (private val bookList: ArrayList<Cuisine_Model>):
        RecyclerView.Adapter<Cuisine_Adapter.ViewHolder>() {

        private lateinit var mListener: OnItemClickListener

        interface OnItemClickListener{
            fun onItemClick(position: Int)
        }

        fun setOnItemClickListener(clickListener: OnItemClickListener){
            mListener = clickListener
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
            val itemView = LayoutInflater.from(parent.context).inflate(R.layout.order_list_activity, parent, false)
            return ViewHolder(itemView, mListener)
        }
        override fun onBindViewHolder(holder:ViewHolder, position: Int){
            val currentBookhotel = bookList[position]
            holder.MenuName.text = currentBookhotel.menu_name

        }

        override fun getItemCount(): Int{
            return bookList.size
        }

        class ViewHolder(itemView: View, clickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView){

            val MenuName: TextView = itemView.findViewById(R.id.menuName_)

            init {
                itemView.setOnClickListener{
                    clickListener.onItemClick(adapterPosition)
                }
            }
        }
    }