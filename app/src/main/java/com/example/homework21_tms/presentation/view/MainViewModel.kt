package com.example.homework21_tms.presentation.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework21_tms.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    private var _userExist = MutableLiveData<Boolean>()
    val userExist: LiveData<Boolean> = _userExist


    fun checkUserExists() {
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, exception ->
            Log.w("Handler", "checkUserExists")
        }
        viewModelScope.launch (coroutineExceptionHandler) {
            try {
                _userExist.value = authInteractor.checkUserExists()
            } catch (e: Exception) {
                Log.w("Exception", "checkUserExists")
            }
        }
    }

    private var _userSawOnBoard = MutableLiveData<Boolean>()
    val userSawOnBoard: LiveData<Boolean> = _userSawOnBoard

    fun checkUserSawOnBoard() {
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, exception ->
            Log.w("Handler", "checkUserExists")
        }
        viewModelScope.launch (coroutineExceptionHandler) {
            try {
                _userSawOnBoard.value = authInteractor.isOnBoardingShows()
            } catch (e: Exception) {
                Log.w("Exception", "checkUserSawOnBoard")
            }
        }
    }
}