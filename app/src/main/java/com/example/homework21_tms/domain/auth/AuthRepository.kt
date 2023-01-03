package com.example.homework21_tms.domain.auth

import com.example.homework21_tms.domain.model.UserModel

interface AuthRepository {

    fun loginUser(userName: String, userPassword: String)

    fun showUserCreds(): UserModel

    fun doesUserExist(): Boolean

    fun userLogout()

    fun saveIfUserSawOnBoard(bool: Boolean)

    fun checkShowsOnBoard(): Boolean
}