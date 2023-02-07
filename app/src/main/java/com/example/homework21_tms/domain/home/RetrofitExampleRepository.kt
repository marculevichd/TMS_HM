package com.example.homework21_tms.domain.home

import com.example.homework21_tms.domain.model.FaveModel
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import kotlinx.coroutines.flow.Flow

interface RetrofitExampleRepository {

    suspend fun getDataFromJson()

    suspend fun showDataFromDataBase(): Flow<List<RetrofitExampleModel>>

    suspend fun favClicked(retrofitExampleModel: RetrofitExampleModel)

    suspend fun getFavorites(): Flow<List<FaveModel>>

    suspend fun findItemById(searchText: Int): RetrofitExampleModel

    suspend fun deleteItemFromFaveEntity(id: Int)

    suspend fun deleteItemFromDataBaseExampleEntity(id: Int)

    suspend fun updateItemById(id: Int, status: Boolean)

}