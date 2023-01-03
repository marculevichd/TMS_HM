package com.example.homework21_tms.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework21_tms.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel(){


    private val _userLogout = MutableLiveData<Unit?>()
    val userLogout : LiveData<Unit?> = _userLogout


    fun logoutUser(){
        authInteractor.logoutUser()
        _userLogout.value = Unit
    }



}