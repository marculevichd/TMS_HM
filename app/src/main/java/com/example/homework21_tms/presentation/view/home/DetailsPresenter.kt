package com.example.homework21_tms.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.homework21_tms.domain.AuthInteractor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val authInteractor: AuthInteractor){


    private val _userLogout = MutableLiveData<Unit?>()
    val userLogout : LiveData<Unit?> = _userLogout


    fun logoutUser(){
        authInteractor.logoutuser()
        _userLogout.value = Unit
    }



}