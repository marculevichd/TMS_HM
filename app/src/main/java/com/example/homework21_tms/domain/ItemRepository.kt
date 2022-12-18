package com.example.homework21_tms.domain

import com.example.homework21_tms.model.ItemsModel

interface ItemRepository {

    fun getData(): List<ItemsModel>


}