package com.example.homework21_tms.domain.auth

import com.example.homework21_tms.domain.model.UserModel
import javax.inject.Inject

class AuthInteractor @Inject constructor(private val authRepository: AuthRepository) {


    fun loginUser(userName: String, userPassword: String) {
        authRepository.loginUser(userName, userPassword)
    }

    fun getUserCreds(): UserModel {
        return authRepository.showUserCreds()
    }

    fun checkUserExists(): Boolean{
        return authRepository.doesUserExist()
    }

    fun logoutUser(){
        authRepository.userLogout()
    }

    fun saveIfUserSawOnBoard(bool: Boolean){
        authRepository.saveIfUserSawOnBoard(bool)
    }

    fun checkShowsOnBoard(): Boolean{
        return authRepository.checkShowsOnBoard()
    }

}