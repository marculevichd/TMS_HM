package com.example.homework21_tms.domain.home

import com.example.homework21_tms.domain.model.RetrofitExampleModel

interface RetrofitExampleRepository {

    suspend fun getDataFromJson()

    suspend fun showDataFromDataBase():List<RetrofitExampleModel>

}