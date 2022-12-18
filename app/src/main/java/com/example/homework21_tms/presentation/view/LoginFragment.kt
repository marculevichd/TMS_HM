package com.example.homework21_tms.presentation.view

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.homework21_tms.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {


    private var _viewBinding: Binding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val btn = view.findViewById<Button>(R.id.check_data_and_go_to_onbording_login_fr)
        val login = view.findViewById<EditText>(R.id.login_login_fr)
        val password = view.findViewById<EditText>(R.id.password_login_fr)



        btn.setOnClickListener {

            if (login.text.isEmpty()) {
                Toast.makeText(context, getString(R.string.cant_emtry), Toast.LENGTH_SHORT).show()
            } else if (password.text.isEmpty()) {
                Toast.makeText(context, getString(R.string.cant_emtry), Toast.LENGTH_SHORT).show()
            } else {
                parentFragmentManager
                    .beginTransaction()
                    .replace(R.id.activity_container, OnBordingFragment())
                    .commit()
            }


        }


    }


}