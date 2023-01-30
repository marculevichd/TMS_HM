package com.example.homework21_tms.domain.home

import android.util.Log
import com.example.homework21_tms.domain.model.FaveModel
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import javax.inject.Inject

class RetrofitExampleInteractor @Inject constructor(private val retrofitExampleRepository: RetrofitExampleRepository) {

    suspend fun getDataFromJson() {
        return retrofitExampleRepository.getDataFromJson()
    }

    suspend fun showDataFromDataBase():List<RetrofitExampleModel>{
        return retrofitExampleRepository.showDataFromDataBase()
    }

    suspend fun onFavClicked (searchText:Int){
        val model = retrofitExampleRepository.findItemById(searchText )
        Log.w("интерактор функция файнд", model.toString() )

        retrofitExampleRepository.favClicked(model)
        Log.w("интерактор ф фав клик", model.toString() )

    }

    suspend fun getFavorites(): List<FaveModel>{
        return retrofitExampleRepository.getFavorites()
    }

    suspend fun findItemById(id: Int): RetrofitExampleModel {
        return retrofitExampleRepository.findItemById(id)
    }

}