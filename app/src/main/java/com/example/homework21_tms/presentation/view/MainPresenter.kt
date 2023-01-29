package com.example.homework21_tms.presentation.view

import android.util.Log
import androidx.navigation.NavDestination
import com.example.homework21_tms.domain.auth.AuthInteractor
import kotlinx.coroutines.*
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {
    private lateinit var mainView: MainView

    fun setView(mainActivity:MainActivity){
        mainView = mainActivity
    }

    fun checkUserExistsAndSawOnboard(){
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "checkUserExistsAndSawOnboard")
        }
        CoroutineScope(Dispatchers.Main + coroutineExceptionHandler).launch {
            mainView.userExistsAndSawOnboard(authInteractor.checkUserExists(), authInteractor.checkShowsOnBoard())
        }
    }

    fun statusVisibility(destination: NavDestination){
        mainView.setStatusVisibility(destination)
    }

}