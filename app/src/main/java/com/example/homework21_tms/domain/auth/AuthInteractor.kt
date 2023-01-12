package com.example.homework21_tms.domain.auth

import com.example.homework21_tms.domain.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val authRepository: AuthRepository) {


    suspend fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
    }

    suspend fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    suspend  fun checkUserExists(): Boolean{
        return authRepository.doesUserExist()
    }

    suspend  fun logoutUser(){
        authRepository.userLogout()
    }

    suspend  fun saveIfUserSawOnBoard(bool: Boolean){
        authRepository.saveIfUserSawOnBoard(bool)
    }

    suspend fun checkShowsOnBoard(): Boolean{
        return authRepository.checkShowsOnBoard()
    }

}