package com.example.dnd5eplayerapp.ui.characterList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.database.Character
import com.example.dnd5eplayerapp.ui.mainMenu.MainMenuFragmentDirections
import kotlinx.android.synthetic.main.character_list_view_item.view.*

class CharacterListAdapter: RecyclerView.Adapter<CharacterListAdapter.ListViewHolder>() {

    private var characterList = emptyList<Character>()

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.character_list_view_item, parent, false))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val currentItem = characterList[position]
        holder.itemView.textView.text = currentItem.id.toString()
//        holder.itemView.strListText.text = currentItem.strength.toString()
//        holder.itemView.dexListText.text = currentItem.dexterity.toString()
//        holder.itemView.consListText.text = currentItem.constitution.toString()
//        holder.itemView.intelListText.text = currentItem.intelligence.toString()
//        holder.itemView.wisListText.text = currentItem.wisdom.toString()
//        holder.itemView.charListText.text = currentItem.charisma.toString()

        holder.itemView.setOnClickListener {
            val action = CharacterListFragmentDirections.actionCharacterListFragmentToDetailFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    fun setData(character: List<Character>) {
        this.characterList = character
        notifyDataSetChanged()
    }
}