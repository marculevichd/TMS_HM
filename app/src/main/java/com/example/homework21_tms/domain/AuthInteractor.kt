package com.example.homework21_tms.domain

import com.example.homework21_tms.domain.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val authRepository: AuthRepository) {

    suspend fun loginUser(userName: String, userPassword: String){
        authRepository.loginUser(userName, userPassword)
    }

    suspend fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    suspend fun checkUserExists():Boolean{
        return authRepository.doesUserExist()
    }

    suspend fun logoutUser(): Unit{
        authRepository.userLogout()
    }


    suspend fun saveResultOnBoard(result:Boolean) {
        authRepository.saveResultOnBoard(result)
    }

    suspend fun isOnBoardingShows(): Boolean {
        return authRepository.isOnBoardingShows()
    }

}