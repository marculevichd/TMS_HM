package com.example.homework21_tms.presentation.view.home

import com.example.homework21_tms.domain.home.RetrofitExampleInteractor
import javax.inject.Inject

class FavePresenter @Inject constructor(private val retrofitExampleInteractor: RetrofitExampleInteractor) {

    private lateinit var view: FaveView

    fun setView(faveFragment: FaveFragment) {
        view = faveFragment
    }





}