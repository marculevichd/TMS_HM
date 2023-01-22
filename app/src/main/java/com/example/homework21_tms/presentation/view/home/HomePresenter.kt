package com.example.homework21_tms.presentation.view.home

import javax.inject.Inject

class HomePresenter @Inject constructor() {

    private lateinit var view: HomeView

    fun setView(homeFragment: HomeFragment) {
        view = homeFragment
    }

}