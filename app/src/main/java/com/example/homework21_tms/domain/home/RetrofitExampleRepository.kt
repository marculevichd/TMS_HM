package com.example.homework21_tms.domain.home

import com.example.homework21_tms.domain.model.FaveModel
import com.example.homework21_tms.domain.model.RetrofitExampleModel

interface RetrofitExampleRepository {

    suspend fun getDataFromJson()

    suspend fun showDataFromDataBase():List<RetrofitExampleModel>

    suspend fun favClicked(retrofitExampleModel: RetrofitExampleModel)

    suspend fun getFavorites(): List<FaveModel>

    suspend fun  findItemById(searchText: Int): RetrofitExampleModel

}