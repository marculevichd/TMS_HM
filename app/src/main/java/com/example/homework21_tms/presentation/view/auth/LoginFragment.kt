package com.example.homework21_tms.presentation.view.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.homework21_tms.App
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentLoginBinding
import com.example.homework21_tms.utils.NavHelper.navigate
import com.example.homework21_tms.utils.NavHelper.replaceGraph
import javax.inject.Inject

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
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)
        loginPresenter.setView(this)



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
                loginPresenter.checkUserSawOnBoard()

            }
        }
    }


    override fun checkOnBoard(userSaw: Boolean) {

        when (userSaw) {
            true -> replaceGraph(R.navigation.home_graph)
            false -> navigate(R.id.action_loginFragment_to_onBoardingFragment)
        }

    }


}