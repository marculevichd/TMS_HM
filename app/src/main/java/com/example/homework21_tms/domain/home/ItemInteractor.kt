package com.example.homework21_tms.domain.home

import com.example.homework21_tms.domain.model.ItemsModel
import javax.inject.Inject

class ItemInteractor @Inject constructor(private val itemRepository: ItemRepository) {

    suspend fun getData(): List<ItemsModel> {
        return itemRepository.getData()
    }

}