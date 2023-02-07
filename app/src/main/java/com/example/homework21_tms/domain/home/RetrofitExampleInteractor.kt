package com.example.homework21_tms.domain.home

import android.util.Log
import com.example.homework21_tms.domain.model.FaveModel
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RetrofitExampleInteractor @Inject constructor(private val retrofitExampleRepository: RetrofitExampleRepository) {

    suspend fun getDataFromJson() {
        return retrofitExampleRepository.getDataFromJson()
    }

    suspend fun showDataFromDataBase(): Flow<List<RetrofitExampleModel>> {
        return retrofitExampleRepository.showDataFromDataBase()
    }

    suspend fun onFavClicked(searchText: Int) {
        val model = retrofitExampleRepository.findItemById(searchText)
        retrofitExampleRepository.favClicked(model)
    }

    suspend fun getFavorites(): Flow<List<FaveModel>> {
        return retrofitExampleRepository.getFavorites()
    }

    suspend fun findItemById(id: Int): RetrofitExampleModel {
        return retrofitExampleRepository.findItemById(id)
    }

    suspend fun onDeleteImageClicked(id: Int) {
        retrofitExampleRepository.deleteItemFromDataBaseExampleEntity(id)
    }

    suspend fun deleteItemById(id: Int) {
        retrofitExampleRepository.deleteItemFromFaveEntity(id)
    }

    suspend fun updateItemById(id: Int, status: Boolean) {
        retrofitExampleRepository.updateItemById(id, status)

    }

}