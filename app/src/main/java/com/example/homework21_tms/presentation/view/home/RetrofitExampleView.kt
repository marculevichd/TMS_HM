package com.example.homework21_tms.presentation.view.home

import com.example.homework21_tms.domain.model.RetrofitExampleModel

interface RetrofitExampleView {

    fun getDataFromJson(retrofitExampleList: List<RetrofitExampleModel>)

}