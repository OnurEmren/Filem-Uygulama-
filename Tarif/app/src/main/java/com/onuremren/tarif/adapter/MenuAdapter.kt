package com.onuremren.tarif.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.onuremren.tarif.databinding.MenuItemBinding
import com.onuremren.tarif.databinding.ShoppingListItemBinding
import com.onuremren.tarif.model.Menu
import com.onuremren.tarif.model.ShoppingList
import com.onuremren.tarif.view.fragment.MenuListFragmentDirections

class MenuAdapter(val menuList: List<Menu>): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    class MenuViewHolder(val binding : MenuItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.binding.menuTextView.text = menuList[position].menu
        holder.itemView.setOnClickListener {
            val action = MenuListFragmentDirections.actionMenuListFragmentToMenuFragment("old",menuList[position].menuid)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return menuList.size
    }


}