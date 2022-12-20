package com.example.homework21_tms.presentation.view

import com.example.homework21_tms.domain.model.ItemsModel

interface ItemsView {

    fun dataReceived(list: List<ItemsModel>)

    fun imageViewClicked(ivClicked: Int)

    fun goToDetails(
        title: String,
        description: Int,
        time: String,
        image: Int
    )


}