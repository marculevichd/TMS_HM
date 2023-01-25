package com.example.homework21_tms.domain.home

import com.example.homework21_tms.domain.model.RetrofitExampleModel
import javax.inject.Inject

class RetrofitExampleInteractor @Inject constructor(private val retrofitExampleRepository: RetrofitExampleRepository) {

    suspend fun getDataFromJson() {
        return retrofitExampleRepository.getDataFromJson()
    }

    suspend fun showDataFromDataBase():List<RetrofitExampleModel>{
        return retrofitExampleRepository.showDataFromDataBase()
    }


}