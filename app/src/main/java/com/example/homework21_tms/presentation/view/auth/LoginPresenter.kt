package com.example.homework21_tms.presentation.view.auth

import com.example.homework21_tms.domain.auth.AuthInteractor
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val authInteractor: AuthInteractor
) {

    private lateinit var view: LoginView

    fun setView(loginFragment: LoginFragment) {
        view = loginFragment
    }

    fun userLogIn (userName: String, userPassword: String){
        authInteractor.loginUser(userName, userPassword)
    }

    fun checkUserSawOnBoard(){
        view.checkOnBoard(authInteractor.checkShowsOnBoard())
    }

}