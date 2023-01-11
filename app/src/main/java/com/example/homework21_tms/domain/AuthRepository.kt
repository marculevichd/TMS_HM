package com.example.homework21_tms.domain

import com.example.homework21_tms.domain.model.UserModel

interface AuthRepository {

    suspend fun loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds():UserModel

    suspend fun doesUserExist():Boolean

    suspend fun userLogout(): Unit

    suspend fun saveResultOnBoard(result:Boolean)

    suspend fun isOnBoardingShows():Boolean

}