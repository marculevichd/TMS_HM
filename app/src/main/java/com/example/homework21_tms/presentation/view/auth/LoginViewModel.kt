package com.example.homework21_tms.presentation.view.auth

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework21_tms.domain.AuthInteractor
import com.example.homework21_tms.presentation.view.home.HomeFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor) :ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    private val _showOnBoard = MutableLiveData<Boolean>()
    val showOnBoard: LiveData<Boolean> = _showOnBoard


    fun loginUser(userName: String, userPassword: String) {
        authInteractor.loginUser(userName, userPassword)
        _nav.value = Unit
    }

    fun whichFragmentToShowIfOnBoardShows() {
        _showOnBoard.value = authInteractor.isOnBoardingShows()
    }
}