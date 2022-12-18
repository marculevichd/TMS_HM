package com.example.homework21_tms.presentation.view

import com.example.homework21_tms.R
import com.example.homework21_tms.domain.ItemInteractor

class ItemPresenter(
    val itemsView: ItemsView,
    val itemInteractor: ItemInteractor
) {

    fun getData() {
        val listItems = itemInteractor.getData()
        itemsView.dataReceived(listItems)
    }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.iv_clicked)
    }

    fun elementSelected(
        title: String,
        description: Int,
        time: String,
        image: Int
    ) {
        itemsView.goToDetails(title, description, time, image)
    }

}