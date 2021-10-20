package com.example.dnd5eplayerapp.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.database.ItemResponse
import com.example.dnd5eplayerapp.databinding.HomeRecyclerviewItemBinding
import kotlinx.android.synthetic.main.home_recyclerview_item.view.*

class HomeAdapter (

        ) : ListAdapter<ItemResponse, HomeAdapter.HomeViewHolder>(HomeListDifCallback()) {

    private var myList = emptyList<ItemResponse>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.HomeViewHolder {
        val view =
            HomeRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.HomeViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class HomeViewHolder(val binding: HomeRecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            var item = getItem(position)

            var count = binding.countTxt
            var result = binding.resultsTxt
            var url = binding.urlTxt

            count.text = item.results[position].name
            Log.i("position", "${position}, ${myList}")
            result.text = item.results.toString()
            url.text = item.results[position].url


//        holder.itemView.results_txt.text = myList[position].results[position].name
//        Log.i("Position", " ${position}, ${myList}")
//        holder.itemView.url_txt.text = myList[position].results.toString()
        }
    }
    fun setData(newList: ItemResponse) {
        myList = listOf(newList)
        Log.i("position", "${myList}")
        notifyDataSetChanged()
    }



}



class HomeListDifCallback: DiffUtil.ItemCallback<ItemResponse>() {
    override fun areContentsTheSame(oldItem: ItemResponse, newItem: ItemResponse): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: ItemResponse, newItem: ItemResponse): Boolean {
        return oldItem == newItem
    }
}


//class HomeAdapter: RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
//
//    private var myList = emptyList<itemResponse>()
//
//    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MyViewHolder {
//        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_recyclerview_item, parent, false))
//    }
//
//    override fun getItemCount(): Int {
//        return myList.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.itemView.count_txt.text = myList[position].results[200].url
//        holder.itemView.results_txt.text = myList[position].results[position].name
//        Log.i("Position", " ${position}, ${myList}")
//        holder.itemView.url_txt.text = myList[position].results.toString()
//    }
//
//    fun setData(newList: itemResponse) {
//        myList = listOf(newList)
//        notifyDataSetChanged()
//    }
//}