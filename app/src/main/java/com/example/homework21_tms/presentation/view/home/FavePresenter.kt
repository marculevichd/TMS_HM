package com.example.homework21_tms.presentation.view.home

import android.util.Log
import com.example.homework21_tms.domain.home.RetrofitExampleInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavePresenter @Inject constructor(private val retrofitExampleInteractor: RetrofitExampleInteractor) {

    private lateinit var view: FaveView

    fun setView(faveFragment: FaveFragment) {
        view = faveFragment
    }


    fun getFavorites() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
               val list =  retrofitExampleInteractor.getFavorites()
                view.getFavorites(list)
            } catch (e: java.lang.Exception) {
                Log.w("getFavorites", e.message.toString())
            }
        }
    }


}