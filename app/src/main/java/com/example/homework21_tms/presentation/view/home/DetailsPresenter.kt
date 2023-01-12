package com.example.homework21_tms.presentation.view.home

import android.util.Log
import com.example.homework21_tms.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var view: DetailsView

    fun setView(detailsFragment: DetailsFragment) {
        view = detailsFragment
    }


    fun logOutUser (){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "logOutUser")
        }
        GlobalScope.launch(Dispatchers.Main +coroutineExceptionHandler) {

            authInteractor.logoutUser()
            view.userLogOut()
        }
    }

    fun showDetailInfo(title: String, description: Int, time: String, image: Int){
        view.showDetailInfo(title, description, time, image)
    }

}