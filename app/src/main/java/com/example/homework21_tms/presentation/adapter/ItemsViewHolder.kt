package com.example.homework21_tms.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.SimpleAdapter.ViewBinder
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.ItemFilmBinding
import com.example.homework21_tms.presentation.adapter.listener.ItemListener
import com.example.homework21_tms.model.ItemsModel

class ItemsViewHolder(
    private val viewBinding: ItemFilmBinding,
    private val itemListener: ItemListener
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(itemsModel: ItemsModel) {


        viewBinding.titleItemFilm.text = itemsModel.title
        viewBinding.descriptionItemFilm.setText(itemsModel.description)
        viewBinding.clockItemFilm.text = itemsModel.time
        viewBinding.imageItemFilm.setBackgroundResource(itemsModel.image)
        viewBinding.imageFaveItemFilm.setBackgroundResource(itemsModel.imageFave)


        var addImageFave = false
        viewBinding.imageFaveItemFilm.setOnClickListener {
            if (addImageFave) {
                viewBinding.imageFaveItemFilm.setImageResource(R.drawable.empty_star)
                addImageFave = false
            } else {
                viewBinding.imageFaveItemFilm.setImageResource(R.drawable.full_star)
            }
        }

        viewBinding.imageItemFilm.setOnClickListener {
            itemListener.onClick()
        }


        itemView.setOnClickListener {
            itemListener.onElementSelected(
                itemsModel.title,
                itemsModel.description,
                itemsModel.time,
                itemsModel.image

            )
        }



    }
}