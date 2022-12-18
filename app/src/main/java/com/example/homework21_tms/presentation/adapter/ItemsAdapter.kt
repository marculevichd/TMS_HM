package com.example.homework21_tms.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.ItemFilmBinding
import com.example.homework21_tms.presentation.adapter.listener.ItemListener
import com.example.homework21_tms.model.ItemsModel

class ItemsAdapter(private val itemsListener: ItemListener) :
    RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = mutableListOf<ItemsModel>()

    fun submitList(list: List<ItemsModel>) {
        this.listItems = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val viewBinding = ItemFilmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//            LayoutInflater.from(parent.context).inflate(R.layout.item_film, parent, false)

        return ItemsViewHolder(viewBinding, itemsListener)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

}