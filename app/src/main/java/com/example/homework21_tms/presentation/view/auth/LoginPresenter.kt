package com.example.homework21_tms.presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.homework21_tms.domain.AuthInteractor
import javax.inject.Inject

// Какая анотация здесь нужна для презентера?
class LoginPresenter @Inject constructor(private val authInteractor: AuthInteractor) {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav


    fun loginUser(userName: String, userPassword: String) {
        authInteractor.loginUser(userName, userPassword)
        _nav.value = Unit
    }


}