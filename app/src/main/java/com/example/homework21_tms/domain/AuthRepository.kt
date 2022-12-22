package com.example.homework21_tms.domain

import com.example.homework21_tms.domain.model.UserModel

interface AuthRepository {

    fun loginUser(userName: String, userPassword: String)

    fun showUserCreds():UserModel

    fun doesUserExist():Boolean

    fun userLogout(): Unit

    fun saveResultOnBoard(result:Boolean)

    fun isOnBoardingShows():Boolean

}