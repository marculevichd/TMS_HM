package com.example.homework21_tms.presentation.view.auth

import javax.inject.Inject

class OnBoardingPresenter @Inject constructor() {

    private lateinit var onBoardingView: OnBoardingView

    fun setView(onBoardingFragment: OnBoardingFragment){
        onBoardingView = onBoardingFragment
    }

    fun goToNextFragment(){
        onBoardingView.goToNextFragment()
    }
}