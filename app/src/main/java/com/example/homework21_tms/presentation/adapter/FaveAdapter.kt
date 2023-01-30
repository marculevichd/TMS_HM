package com.example.homework21_tms.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework21_tms.databinding.FragmentFaveBinding
import com.example.homework21_tms.databinding.ItemFaveBinding
import com.example.homework21_tms.domain.model.FaveModel
import com.example.homework21_tms.presentation.adapter.listener.FaveListener
import com.example.homework21_tms.presentation.adapter.listener.RetrofitExampleListener

class FaveAdapter(
    private val faveListener: FaveListener
    ) : RecyclerView.Adapter<FaveViewHolder>() {

    private var listItems = mutableListOf<FaveModel>()

    fun submitList(list: List<FaveModel>) {
        this.listItems.clear()
        this.listItems.addAll(list.toMutableList())
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FaveViewHolder {
        val binding = ItemFaveBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FaveViewHolder(binding, faveListener)
    }

    override fun onBindViewHolder(holder: FaveViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }


}

