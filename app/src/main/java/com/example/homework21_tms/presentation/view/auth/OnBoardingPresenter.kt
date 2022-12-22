package com.example.homework21_tms.presentation.view.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.homework21_tms.domain.AuthInteractor
import javax.inject.Inject

class OnBoardingPresenter@Inject constructor(private val authInteractor: AuthInteractor) {


    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun saveOnBoard(result: Boolean) {
        authInteractor.saveResultOnBoard(result)
        _nav.value = Unit
    }

}