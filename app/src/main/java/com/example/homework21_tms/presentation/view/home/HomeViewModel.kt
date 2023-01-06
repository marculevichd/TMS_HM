package com.example.homework21_tms.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework21_tms.domain.AuthInteractor
import com.example.homework21_tms.domain.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {


    private val _nav = MutableLiveData<UserModel>()
    val nav: LiveData<UserModel> = _nav

    fun showUserCreds() {
        _nav.value = authInteractor.getUserCreds()
    }


}