package com.onuremren.tarif.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.onuremren.tarif.R
import com.onuremren.tarif.databinding.ItemListBinding
import com.onuremren.tarif.model.Eat
import com.onuremren.tarif.view.fragment.ListFragmentDirections

class EatAdapter(val eatList : List<Eat>) : RecyclerView.Adapter<EatAdapter.EatViewHolder>() {

    class EatViewHolder(val binding : ItemListBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EatViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EatViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return eatList.size
    }

    override fun onBindViewHolder(holder: EatViewHolder, position: Int) {

        holder.binding.tvTitleRecipes.text = eatList[position].title
        holder.binding.tvDetailText.text = eatList[position].malzeme
        holder.itemView.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToMyRecipeFragment("old",eatList[position].uid)
            Navigation.findNavController(it).navigate(action)

        }
    }
}