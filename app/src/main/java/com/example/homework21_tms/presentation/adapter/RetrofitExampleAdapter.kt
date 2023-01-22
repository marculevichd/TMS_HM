package com.example.homework21_tms.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homework21_tms.databinding.ItemUsersFromJsonBinding
import com.example.homework21_tms.domain.model.RetrofitExampleModel

class RetrofitExampleAdapter: RecyclerView.Adapter<RetrofitExampleViewHolder>(){

    private var listUser = mutableListOf<RetrofitExampleModel>()

    fun submitList(list: List<RetrofitExampleModel>) {
        this.listUser.clear()
        this.listUser.addAll(list.toMutableList())
        this.notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitExampleViewHolder {
        val viewBinding = ItemUsersFromJsonBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RetrofitExampleViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: RetrofitExampleViewHolder, position: Int) {
        holder.bind(listUser[position])
    }

    override fun getItemCount(): Int {
        return listUser.size
    }
}