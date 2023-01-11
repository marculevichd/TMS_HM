package com.example.homework21_tms.presentation.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework21_tms.domain.AuthInteractor
import com.example.homework21_tms.domain.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {


    private val _nav = MutableLiveData<UserModel>()
    val nav: LiveData<UserModel> = _nav

    fun showUserCreds() {
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, exception ->
            Log.w("Handler", "checkUserExists")
        }
        viewModelScope.launch (coroutineExceptionHandler) {
            try {
                _nav.value = authInteractor.getUserCreds()
            } catch (e: Exception) {
                Log.w("Exception", "showUserCreds")
            }
        }
    }
}