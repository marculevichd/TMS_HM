package com.example.homework21_tms.domain.auth

import com.example.homework21_tms.domain.model.UserModel

interface AuthRepository {

    suspend fun loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds(): UserModel

    suspend fun doesUserExist(): Boolean

    suspend  fun userLogout()

    suspend fun saveIfUserSawOnBoard(bool: Boolean)

    suspend fun checkShowsOnBoard(): Boolean
}