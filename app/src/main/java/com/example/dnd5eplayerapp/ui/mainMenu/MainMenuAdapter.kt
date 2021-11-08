package com.example.dnd5eplayerapp.ui.mainMenu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dnd5eplayerapp.R
import com.example.dnd5eplayerapp.database.MenuItem
import com.example.dnd5eplayerapp.databinding.MainMenuItemBinding

class MainMenuAdapter(val viewModel: MainMenuViewModel) : ListAdapter <MenuItem, MainMenuAdapter.MenuViewHolder>(MenuListDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuAdapter.MenuViewHolder {
        val view =
            MainMenuItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainMenuAdapter.MenuViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class MenuViewHolder(val binding: MainMenuItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
           val item = getItem(position)

            binding.mainMenuItem.setOnClickListener {
                viewModel.setMenuItem(item)
            }

            binding.mainMenuItem.setOnClickListener {
                val action = MainMenuFragmentDirections.actionMainMenuFragmentToCharacterListFragment()
                binding.mainMenuItem.findNavController().navigate(action)
            }

            var imageView = binding.iconView
            var textView = binding.textView

            imageView.setImageResource(item.image)
            textView.text = item.name
        }
    }
}
class MenuListDiffCallback : DiffUtil.ItemCallback<MenuItem>() {
    override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
        return oldItem == newItem
    }

}

