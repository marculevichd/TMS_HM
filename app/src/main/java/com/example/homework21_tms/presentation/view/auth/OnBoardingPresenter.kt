package com.example.homework21_tms.presentation.view.auth

import android.util.Log
import com.example.homework21_tms.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class OnBoardingPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var onBoardingView: OnBoardingView

    fun setView(onBoardingFragment: OnBoardingFragment) {
        onBoardingView = onBoardingFragment
    }

    fun goToNextFragment() {
        onBoardingView.goToNextFragment()
    }

    fun showUserCreds() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "userLogIn")
        }
        GlobalScope.launch(Dispatchers.Main + coroutineExceptionHandler) {

            try {
                onBoardingView.showUserCreds(authInteractor.getUserCreds())
            } catch (e: Exception) {
                Log.w("Exception", "showUserCreds")
            }
        }
    }


    fun saveIfUserSaveOnBoard(boolean: Boolean) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "userLogIn")
        }
        GlobalScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            try {
                authInteractor.saveIfUserSawOnBoard(boolean)
            } catch (e: Exception) {
                Log.w("Exception", "saveIfUserSaveOnBoard")
            }
        }
    }

}