package com.example.homework21_tms.presentation.view

import com.example.homework21_tms.domain.auth.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var mainView: MainView

    fun setView(mainActivity:MainActivity){
        mainView = mainActivity
    }

    fun checkUserExistsAndSawOnboard(){
        mainView.userExistsAndSawOnboard(authInteractor.checkUserExists(), authInteractor.checkShowsOnBoard())
    }

}