package com.example.homework21_tms.domain.auth

import com.example.homework21_tms.domain.model.UserModel
import com.example.homework21_tms.domain.model.WorkManagerModel

interface AuthRepository {

    suspend fun loginUser(userName: String, userPassword: String)

    suspend fun showUserCreds(): UserModel

    suspend fun doesUserExist(): Boolean

    suspend  fun userLogout()

    suspend fun saveIfUserSawOnBoard(bool: Boolean)

    suspend fun checkShowsOnBoard(): Boolean

    suspend fun getStringWorkManager(): WorkManagerModel

    suspend fun saveStringWorkManager(string: WorkManagerModel)

}