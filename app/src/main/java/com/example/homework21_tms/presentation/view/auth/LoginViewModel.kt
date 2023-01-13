package com.example.homework21_tms.presentation.view.auth

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework21_tms.R
import com.example.homework21_tms.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    private val _saveUser = MutableLiveData<Unit>()
    val saveUser: LiveData<Unit> = _saveUser

    private val _nav = MutableLiveData<NavLoginToOnBoard?>()
    val nav: LiveData<NavLoginToOnBoard?> = _nav



    fun loginUser(userName: String, userPassword: String) {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "checkUserExists")
        }
        viewModelScope.launch(Dispatchers.Main + coroutineExceptionHandler) {
            try {
                authInteractor.loginUser(userName, userPassword)
                _saveUser.value = Unit
            } catch (e: Exception) {
                Log.w("Exception", "loginUser")
            }
        }
    }

    fun navToOnBoard(){
        _nav.value =  NavLoginToOnBoard (R.id.action_loginFragment_to_onBordingFragment, R.id.loginFragment)
    }

    fun userNavigated() {
        _nav.value = null
    }
}

data class NavLoginToOnBoard(val destinationId: Int, val fragmentToDelete: Int)