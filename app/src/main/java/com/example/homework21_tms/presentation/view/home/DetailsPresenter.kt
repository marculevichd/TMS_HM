package com.example.homework21_tms.presentation.view.home

import com.example.homework21_tms.domain.auth.AuthInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var view: DetailsView

    fun setView(detailsFragment: DetailsFragment) {
        view = detailsFragment
    }


    fun logOutUser (){
        authInteractor.logoutUser()
        view.userLogOut()
    }

    fun showDetailInfo(title: String, description: Int, time: String, image: Int){
        view.showDetailInfo(title, description, time, image)
    }

}