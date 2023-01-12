package com.example.homework21_tms.data

import android.content.SharedPreferences
import com.example.homework21_tms.domain.model.UserModel
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(private val sharedPreferences: SharedPreferences) {


    fun saveUserName(name: String?) {
        sharedPreferences.edit().putString(USER_NAME, name).apply()
    }

    fun saveUserPassword(password: String?) {
        sharedPreferences.edit().putString(USER_PASSWORD, password).apply()
    }

    fun getUserCreds(): UserModel {
        return UserModel(
            sharedPreferences.getString(USER_NAME, "") ?: "no user",
            sharedPreferences.getString(USER_PASSWORD, "") ?: "no user pass",
        )
    }

    fun checkUserExists(): Boolean {
        return (
        !sharedPreferences.getString(USER_NAME, "").isNullOrEmpty() &&
        !sharedPreferences.getString(USER_PASSWORD, "").isNullOrEmpty())
    }

    fun removeUser() {
        saveUserName(null)
        saveUserPassword(null)
    }

    fun saveIfUserSawOnBoard (bool: Boolean){
        sharedPreferences.edit().putBoolean(SHOW_ONBOARD, bool).apply()
    }

    fun checkShowsOnBoard(): Boolean {
        return (sharedPreferences.getBoolean(SHOW_ONBOARD, false))
    }

    companion object {
        private const val USER_NAME = "USER NAME"
        private const val USER_PASSWORD = "USER PASSWORD"
        private const val SHOW_ONBOARD = "SHOW ONBOARD"
    }
}

