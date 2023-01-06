package com.example.homework21_tms.presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework21_tms.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel@Inject constructor(private val authInteractor: AuthInteractor) :ViewModel(){


    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun saveOnBoard(result: Boolean) {
        authInteractor.saveResultOnBoard(result)
        _nav.value = Unit
    }

    private var _userSawOnBoard = MutableLiveData<Boolean>()
    val userSawOnBoard: LiveData<Boolean> = _userSawOnBoard

    fun checkUserSawOnBoard() {
        _userSawOnBoard.value = authInteractor.isOnBoardingShows()
    }


}