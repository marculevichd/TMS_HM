package com.example.homework21_tms.presentation.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework21_tms.R
import com.example.homework21_tms.domain.AuthInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val authInteractor: AuthInteractor) :
    ViewModel() {


    private val _userLogout = MutableLiveData<Int?>()
    val userLogout: LiveData<Int?> = _userLogout


    fun logoutUser() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "checkUserExists")
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                authInteractor.logoutUser()
                _userLogout.value = R.navigation.auth_graph
            } catch (e: Exception) {
                Log.w("Exception", "logoutUser")
            }
        }
    }
}