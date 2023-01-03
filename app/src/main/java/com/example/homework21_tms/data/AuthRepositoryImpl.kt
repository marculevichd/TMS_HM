package com.example.homework21_tms.data

import com.example.homework21_tms.domain.auth.AuthRepository
import com.example.homework21_tms.domain.model.UserModel
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {


    override fun loginUser(userName: String, userPassword: String) {
        sharedPreferencesHelper.saveUserName(userName)
        sharedPreferencesHelper.saveUserPassword(userPassword)
    }

    override fun showUserCreds(): UserModel {
        return sharedPreferencesHelper.getUserCreds()
    }

    override fun doesUserExist(): Boolean {
        return sharedPreferencesHelper.checkUserExists()
    }

    override fun userLogout() {
        sharedPreferencesHelper.removeUser()
    }

    override fun saveIfUserSawOnBoard(bool: Boolean) {
        sharedPreferencesHelper.saveIfUserSawOnBoard(bool)
    }

    override fun checkShowsOnBoard(): Boolean {
        return sharedPreferencesHelper.checkShowsOnBoard()
    }

}