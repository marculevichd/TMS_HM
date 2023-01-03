package com.example.homework21_tms.presentation.view

import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework21_tms.domain.AuthInteractor
import com.example.homework21_tms.presentation.view.auth.LoginFragment
import com.example.homework21_tms.presentation.view.auth.OnBordingFragment
import com.example.homework21_tms.presentation.view.home.HomeFragment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel

class MainViewModel @Inject constructor(private val authInteractor: AuthInteractor): ViewModel() {

//    private val _userExist = MutableLiveData<Boolean>()
//    val userExist: LiveData<Boolean> = _userExist

//
//    fun checkUserExists() {
//        _userExist.value = authInteractor.checkUserExists()
//    }


    private val _whichFragmentToShow = MutableLiveData<Fragment>()
    val whichFragmentToShow: LiveData<Fragment> = _whichFragmentToShow

    fun whichFragmentToShow() {
            if (authInteractor.checkUserExists() == true && authInteractor.isOnBoardingShows() == true) {
                _whichFragmentToShow.value =HomeFragment()
            } else if (authInteractor.checkUserExists() == true && authInteractor.isOnBoardingShows() == false) {
                _whichFragmentToShow.value =OnBordingFragment()
            } else if (authInteractor.checkUserExists() == false && authInteractor.isOnBoardingShows() == false) {
                _whichFragmentToShow.value =LoginFragment()
            }
    }

}