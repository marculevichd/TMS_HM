package com.example.homework21_tms.presentation.view.auth

import com.example.homework21_tms.domain.model.UserModel

interface OnBoardingView {

    fun goToNextFragment()

    fun showUserCreds(userModel: UserModel)
}