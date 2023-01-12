package com.example.homework21_tms.presentation.view.auth

import com.example.homework21_tms.domain.auth.AuthInteractor
import javax.inject.Inject

class OnBoardingPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private lateinit var onBoardingView: OnBoardingView

    fun setView(onBoardingFragment: OnBoardingFragment) {
        onBoardingView = onBoardingFragment
    }

    fun goToNextFragment() {
        onBoardingView.goToNextFragment()
    }

    fun showUserCreds() {
        onBoardingView.showUserCreds(authInteractor.getUserCreds())
    }


    fun saveIfUserSaveOnBoard(boolean: Boolean) {
        authInteractor.saveIfUserSawOnBoard(boolean)
    }

}