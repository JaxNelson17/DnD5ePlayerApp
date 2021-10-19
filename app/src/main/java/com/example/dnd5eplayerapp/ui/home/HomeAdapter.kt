package com.example.dnd5eplayerapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.database.Result
import com.example.dnd5eplayerapp.database.itemResponse
import com.example.dnd5eplayerapp.database.responseMenu
import kotlinx.android.synthetic.main.home_recyclerview_item.view.*

class HomeAdapter: RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    private var myList = emptyList<itemResponse>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_recyclerview_item, parent, false))
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.count_txt.text = myList[position].count.toString()
        holder.itemView.results_txt.text = myList[position].results.toString()
    }

    fun setData(newList: itemResponse) {
        myList = listOf(newList)
        notifyDataSetChanged()
    }

}