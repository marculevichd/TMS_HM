package com.example.homework21_tms.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.ActivityMainBinding
import com.example.homework21_tms.presentation.view.auth.LoginFragment
import com.example.homework21_tms.presentation.view.auth.OnBordingFragment
import com.example.homework21_tms.presentation.view.home.HomeFragment
import com.example.homework21_tms.presentation.view.home.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: ActivityMainBinding? = null

    private lateinit var observeUserSawOnBoard: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(_binding!!.root)







        viewModel.checkUserSawOnBoard()

        viewModel.userSawOnBoard.observe(this) {
            when (it) {
                false -> observeUserSawOnBoard = OnBordingFragment()
                true -> observeUserSawOnBoard = HomeFragment()
            }
        }

        viewModel.checkUserExists()

        viewModel.userExist.observe(this) {

            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(
                R.id.activity_container,
                when (it) {
                    false -> LoginFragment()
                    true -> observeUserSawOnBoard
                }
            )
            fragmentTransaction.commit()
        }
    }
}

