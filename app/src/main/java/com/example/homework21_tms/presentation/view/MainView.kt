package com.example.homework21_tms.presentation.view

import androidx.navigation.NavDestination

interface MainView {

    fun userExistsAndSawOnboard(userExists:Boolean, userSaw:Boolean)

    fun setStatusVisibility(destination: NavDestination)

}