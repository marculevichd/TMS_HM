package com.example.homework21_tms.presentation.view.auth

import android.util.Log
import com.example.homework21_tms.domain.auth.AuthInteractor
import kotlinx.coroutines.*
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

        CoroutineScope(Dispatchers.Main + coroutineExceptionHandler).launch{
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
        CoroutineScope(Dispatchers.Main + coroutineExceptionHandler).launch{
            view.checkOnBoard(authInteractor.checkShowsOnBoard())
        }
    }

}