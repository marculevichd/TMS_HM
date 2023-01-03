package com.example.homework21_tms.domain

import com.example.homework21_tms.domain.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val authRepository: AuthRepository) {

    fun loginUser(userName: String, userPassword: String){
        authRepository.loginUser(userName, userPassword)
    }

    fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    fun checkUserExists():Boolean{
        return authRepository.doesUserExist()
    }

    fun logoutUser(): Unit{
        authRepository.userLogout()
    }


    fun saveResultOnBoard(result:Boolean) {
        authRepository.saveResultOnBoard(result)
    }

     fun isOnBoardingShows(): Boolean {
        return authRepository.isOnBoardingShows()
    }

}