package com.example.homework21_tms.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentLoginBinding
import com.example.homework21_tms.presentation.view.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val callBack = requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (isEnabled) {
                        isEnabled = false
                        requireActivity().onBackPressed()
                    }
                }
            })
    }


    private val loginViewModel: LoginViewModel by viewModels()

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

        viewBinding.checkDataAndGoToOnbordingLoginFr.setOnClickListener {

            if (viewBinding.loginLoginFr.text?.isEmpty() == true) {
                Toast.makeText(context, getString(R.string.cant_emtry), Toast.LENGTH_SHORT).show()
            } else if (viewBinding.passwordLoginFr.text?.isEmpty() == true) {
                Toast.makeText(context, getString(R.string.cant_emtry), Toast.LENGTH_SHORT).show()
            } else {
                loginViewModel.loginUser(
                    viewBinding.loginLoginFr.text.toString(),
                    viewBinding.passwordLoginFr.text.toString()
                )

                loginViewModel.whichFragmentToShowIfOnBoardShows()

                loginViewModel.showOnBoard.observe(viewLifecycleOwner) {
                    parentFragmentManager
                        .beginTransaction()
                        .replace(R.id.activity_container, loginViewModel.showOnBoard.value!!)
                        .commit()
                }
            }
        }
    }
}

