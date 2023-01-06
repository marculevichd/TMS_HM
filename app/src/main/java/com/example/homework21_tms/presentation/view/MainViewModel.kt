package com.example.homework21_tms.presentation.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework21_tms.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(private val authInteractor: AuthInteractor): ViewModel() {

    private var _userExist = MutableLiveData<Boolean>()
    val userExist: LiveData<Boolean> = _userExist


    fun checkUserExists() {
        _userExist.value = authInteractor.checkUserExists()
    }

    private var _userSawOnBoard = MutableLiveData<Boolean>()
    val userSawOnBoard: LiveData<Boolean> = _userSawOnBoard

    fun checkUserSawOnBoard() {
        _userSawOnBoard.value = authInteractor.isOnBoardingShows()
    }
}