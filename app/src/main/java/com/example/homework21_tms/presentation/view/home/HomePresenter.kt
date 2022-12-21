package com.example.homework21_tms.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.homework21_tms.domain.AuthInteractor
import com.example.homework21_tms.domain.model.UserModel
import javax.inject.Inject

class HomePresenter @Inject constructor(private val authInteractor: AuthInteractor){

    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCreds


    fun showUserData(){
        _userCreds.value = authInteractor.getUserCreds()
    }
}