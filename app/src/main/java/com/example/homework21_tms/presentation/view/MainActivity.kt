package com.example.homework21_tms.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.ActivityMainBinding
import com.example.homework21_tms.presentation.view.auth.LoginFragment
import com.example.homework21_tms.presentation.view.auth.OnBoardingFragment
import com.example.homework21_tms.presentation.view.home.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        mainPresenter.setView(this)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController

        mainPresenter.checkUserExistsAndSawOnboard()

    }

    override fun userExistsAndSawOnboard(userExists: Boolean, userSaw: Boolean) {

        when (userExists) {
            false -> {

                val navGraph = navController.navInflater.inflate(R.navigation.auth_graph)
                navGraph.setStartDestination(R.id.loginFragment)
                navController.graph =navGraph
            }
            true -> when (userSaw) {
                true -> navController.setGraph(R.navigation.home_graph)
                false -> {

                    val navGraph = navController.navInflater.inflate(R.navigation.auth_graph)
                    navGraph.setStartDestination(R.id.onBoardingFragment)
                    navController.graph =navGraph

                }
            }
        }
    }



}