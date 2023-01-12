package com.example.homework21_tms.presentation.view.auth

import android.util.Log
import com.example.homework21_tms.domain.auth.AuthInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var view: LoginView

    fun setView(loginFragment: LoginFragment) {
        view = loginFragment
    }

    fun userLogIn(userName: String, userPassword: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "userLogIn")
        }

        GlobalScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            try {
                authInteractor.loginUser(userName, userPassword)
            } catch (e: Exception) {
                Log.w("Exception", "userLogIn")
            }
        }
    }

    fun checkUserSawOnBoard() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "checkUserSawOnBoard")
        }
        GlobalScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            view.checkOnBoard(authInteractor.checkShowsOnBoard())
        }
    }

}