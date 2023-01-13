package com.example.homework21_tms.presentation.view

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

class MainViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {

    private var _resultCheckUserExists = MutableLiveData<Int>()
    val resultCheckUserExists: LiveData<Int> =
        _resultCheckUserExists

    fun checkResultUserExist() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "checkResultUserExist")
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                val userExist: Boolean = authInteractor.checkUserExists()
                _resultCheckUserExists.value =
                    when (userExist) {
                        true -> R.navigation.main_graph
                        false -> R.navigation.auth_graph
                    }
            } catch (e: Exception) {
                Log.w("Exception", "checkUserSawOnBoard")
            }
        }
    }
}