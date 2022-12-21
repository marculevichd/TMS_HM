package com.example.homework21_tms.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.homework21_tms.domain.AuthInteractor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val authInteractor: AuthInteractor){

    private val _userExist = MutableLiveData<Boolean>()
    val userExist : LiveData <Boolean> = _userExist


    fun checkUserExists(){
        _userExist.value  = authInteractor.checkUserExists()
    }

}