package com.example.homework21_tms.data

import android.content.SharedPreferences
import com.example.homework21_tms.domain.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    fun saveUserName(name: String?) {
        sharedPreferences.edit().putString(USER_NAME, name).apply()
    }

    fun saveUserPassword(password: String?) {
        sharedPreferences.edit().putString(USER_PASSWORD, password).apply()
    }


    fun getUserCreds(): UserModel {
        val name = sharedPreferences.getString(USER_NAME, "") ?: ""
        val password = sharedPreferences.getString(USER_PASSWORD, "") ?: ""
        return UserModel(name, password)
    }


    fun checkUserExists(): Boolean {
        val name = sharedPreferences.getString(USER_NAME, "")
        val password = sharedPreferences.getString(USER_PASSWORD, "")

        return (!name.isNullOrEmpty() && !password.isNullOrEmpty())
    }

    fun removeUser(): Unit {
        saveUserName(null)
        saveUserPassword(null)
    }


    fun saveResultOnBoard(result: Boolean) {
        sharedPreferences.edit().putBoolean(SHOW_ONBOARD, result).apply()
    }

    fun isOnBoardingShows():Boolean{
        return sharedPreferences.getBoolean(SHOW_ONBOARD,false)
    }


    companion object {
        private const val USER_NAME = "USER_NAME"
        private const val USER_PASSWORD = "USER_PASSWORD"
        private const val SHOW_ONBOARD = "SHOW_ONBOARD"
        }

}