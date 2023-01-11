package com.example.homework21_tms.presentation.view.auth

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
class OnBoardingViewModel @Inject constructor(private val authInteractor: AuthInteractor) :
    ViewModel() {


    private val _nav = MutableLiveData<Unit?>()
    val nav: LiveData<Unit?> = _nav

    fun saveOnBoard(result: Boolean) {
        val coroutineExceptionHandler = CoroutineExceptionHandler{_, exception ->
            Log.w("Handler", "checkUserExists")
        }
        viewModelScope.launch (coroutineExceptionHandler) {
            try {
                authInteractor.saveResultOnBoard(result)
                _nav.value = Unit
            } catch (e: Exception) {
                Log.w("Exception", "saveOnBoard")
            }
        }
    }
}