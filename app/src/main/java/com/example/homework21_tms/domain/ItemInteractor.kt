package com.example.homework21_tms.domain

import com.example.homework21_tms.model.ItemsModel
import javax.inject.Inject

class ItemInteractor @Inject constructor(private val itemRepository: ItemRepository) {

    fun getData(): List<ItemsModel> {
        return itemRepository.getData()
    }

}