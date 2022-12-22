package com.example.homework21_tms.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentDetailsBinding
import com.example.homework21_tms.databinding.FragmentLoginBinding
import com.example.homework21_tms.presentation.view.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

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


        val btn = view.findViewById<Button>(R.id.check_data_and_go_to_onbording_login_fr)
        val login = view.findViewById<EditText>(R.id.login_login_fr)
        val password = view.findViewById<EditText>(R.id.password_login_fr)


        loginPresenter.checkOnBoard()


        btn.setOnClickListener {

            if (login.text.isEmpty()) {
                Toast.makeText(context, getString(R.string.cant_emtry), Toast.LENGTH_SHORT).show()
            } else if (password.text.isEmpty()) {
                Toast.makeText(context, getString(R.string.cant_emtry), Toast.LENGTH_SHORT).show()
            } else {

                loginPresenter.loginUser(login.text.toString(), password.text.toString())

                loginPresenter.nav.observe(viewLifecycleOwner) {

                    loginPresenter.showOnBoard.observe(viewLifecycleOwner){
                        parentFragmentManager
                            .beginTransaction()
                            .replace(    R.id.activity_container, when (it) {
                                true -> HomeFragment()
                                false -> OnBordingFragment()})
                            .commit()
                    }

                }
            }
        }
    }
}

