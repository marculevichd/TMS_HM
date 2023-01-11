package com.example.homework21_tms.presentation.view.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework21_tms.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    private val _showOnBoard = MutableLiveData<Boolean>()
    val showOnBoard: LiveData<Boolean> = _showOnBoard


    fun loginUser(userName: String, userPassword: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "checkUserExists")
        }
        viewModelScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            try {
                authInteractor.loginUser(userName, userPassword)
                _nav.value = Unit
            } catch (e: Exception) {
                Log.w("Exception", "loginUser")
            }
        }

    }

    fun whichFragmentToShowIfOnBoardShows() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "checkUserExists")
        }
        viewModelScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            try {
                _showOnBoard.value = authInteractor.isOnBoardingShows()
            } catch (e: Exception) {
                Log.w("Exception", "whichFragmentToShowIfOnBoardShows")
            }
        }
    }
}
