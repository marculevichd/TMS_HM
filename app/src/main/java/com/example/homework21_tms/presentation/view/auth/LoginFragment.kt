package com.example.homework21_tms.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentLoginBinding
import com.example.homework21_tms.presentation.view.home.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment(), LoginView {


    @Inject
    lateinit var loginPresenter: LoginPresenter

    private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginPresenter.setView(this)

        loginPresenter.checkUserSawOnBoard()


        viewBinding.checkDataAndGoToOnbordingLoginFr.setOnClickListener {

            if (viewBinding.loginLoginFr.text?.isEmpty() == true) {
                Toast.makeText(context, getString(R.string.cant_emtry), Toast.LENGTH_SHORT).show()
            } else if (viewBinding.passwordLoginFr.text?.isEmpty() == true) {
                Toast.makeText(context, getString(R.string.cant_emtry), Toast.LENGTH_SHORT).show()
            } else {

                loginPresenter.userLogIn(
                    viewBinding.loginLoginFr.text.toString(),
                    viewBinding.passwordLoginFr.text.toString()
                )
            }
        }
    }


    override fun checkOnBoard(userSaw: Boolean) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container,
                when (userSaw) {
                    true -> ItemsFragment()
                    false -> OnBoardingFragment()})
            .commit()
    }


}