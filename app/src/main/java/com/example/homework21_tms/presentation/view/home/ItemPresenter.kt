package com.example.homework21_tms.presentation.view.home

import com.example.homework21_tms.R
import com.example.homework21_tms.domain.ItemInteractor
import com.example.homework21_tms.presentation.view.home.ItemsView
import javax.inject.Inject

class ItemPresenter @Inject constructor(
    val itemInteractor: ItemInteractor
) {

    private lateinit var itemsView: ItemsView // убрали из конструктора и добавли метод set

    fun setView(context: ItemsView){
        itemsView = context
    }


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