package com.example.homework21_tms.data

import com.example.homework21_tms.domain.auth.AuthRepository
import com.example.homework21_tms.domain.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val sharedPreferencesHelper: SharedPreferencesHelper
) : AuthRepository {


    override suspend fun loginUser(userName: String, userPassword: String) {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.saveUserName(userName)
            sharedPreferencesHelper.saveUserPassword(userPassword)
        }
    }

    override suspend fun showUserCreds(): UserModel {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.getUserCreds()
        }
    }

    override suspend fun doesUserExist(): Boolean {
        return withContext(Dispatchers.IO) {
            sharedPreferencesHelper.checkUserExists()
        }
    }

    override suspend fun userLogout() {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.removeUser()
        }
    }

    override suspend fun saveIfUserSawOnBoard(bool: Boolean) {
        withContext(Dispatchers.IO) {
            sharedPreferencesHelper.saveIfUserSawOnBoard(bool)
        }
    }

    override suspend fun checkShowsOnBoard(): Boolean {
        return withContext(Dispatchers.IO) {
             sharedPreferencesHelper.checkShowsOnBoard()
        }
    }
}