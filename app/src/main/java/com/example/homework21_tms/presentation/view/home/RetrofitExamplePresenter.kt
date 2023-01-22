package com.example.homework21_tms.presentation.view.home

import android.util.Log
import com.example.homework21_tms.domain.home.RetrofitExampleInteractor
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import kotlinx.coroutines.*
import javax.inject.Inject

class RetrofitExamplePresenter @Inject constructor(private val retrofitExampleInteractor: RetrofitExampleInteractor) {

    private lateinit var view: RetrofitExampleView

    fun setView(retrofitExampleFragment: RetrofitExampleFragment) {
        view = retrofitExampleFragment
    }

     fun getDataFromJson() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("exceptionHandler called", exception.toString())
        }
        CoroutineScope(Dispatchers.Main).launch(CoroutineName("with exception") + Dispatchers.Main + coroutineExceptionHandler) {
            try {
                val job = launch {
                    val retrofitExampleList = retrofitExampleInteractor.getDataFromJson()
                    view.getDataFromJson(retrofitExampleList)
                }
            } catch (e: Exception) {
                Log.w("exception", "list items FAILED")
            }
        }
    }





}
