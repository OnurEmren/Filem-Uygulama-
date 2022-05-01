package com.onuremren.tarif.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.onuremren.tarif.R

import com.onuremren.tarif.databinding.ShoppingListItemBinding
import com.onuremren.tarif.model.ShoppingList
import com.onuremren.tarif.view.*
import com.onuremren.tarif.view.fragment.ShoppingDetailFragmentDirections

class ShoppingListAdapter(val shoppingList: List<ShoppingList>): RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>() {

    class ShoppingListViewHolder(val binding : ShoppingListItemBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShoppingListAdapter.ShoppingListViewHolder {

        val binding = ShoppingListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ShoppingListViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: ShoppingListAdapter.ShoppingListViewHolder,
        position: Int
    ) {
        holder.binding.shoppingListTv.text = shoppingList[position].shoppingList
        holder.itemView.setOnClickListener {
            val action = ShoppingDetailFragmentDirections.actionShoppingDetailFragmentToListOfShoppingFragment("old",shoppingList[position].id)
            Navigation.findNavController(it).navigate(action)
        }
    }
    override fun getItemCount(): Int {
        return shoppingList.size
    }
}