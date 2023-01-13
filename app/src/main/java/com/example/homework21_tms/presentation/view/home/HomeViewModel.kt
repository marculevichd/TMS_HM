package com.example.homework21_tms.presentation.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework21_tms.R
import com.example.homework21_tms.domain.AuthInteractor
import com.example.homework21_tms.domain.model.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val authInteractor: AuthInteractor) : ViewModel() {


    private val _userCreds = MutableLiveData<UserModel>()
    val userCreds: LiveData<UserModel> = _userCreds

    private val _nav = MutableLiveData<Int?>()
    val nav: LiveData<Int?> = _nav

    fun showUserCreds() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "checkUserExists")
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                _userCreds.value = authInteractor.getUserCreds()
            } catch (e: Exception) {
                Log.w("Exception", "showUserCreds")
            }
        }
    }

    fun nav() {
        val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            Log.w("Handler", "nav")
        }
        viewModelScope.launch(coroutineExceptionHandler) {
            try {
                _nav.value = R.id.action_homeFragment_to_itemsFragment
            } catch (e: Exception) {
                Log.w("Exception", "nav")
            }
        }
    }
}