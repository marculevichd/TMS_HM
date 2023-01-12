package com.example.homework21_tms.domain.home

import com.example.homework21_tms.domain.model.ItemsModel

interface ItemRepository {

    suspend fun getData(): List<ItemsModel>


}