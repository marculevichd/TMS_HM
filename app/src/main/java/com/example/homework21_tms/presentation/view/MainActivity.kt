package com.example.homework21_tms.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.ActivityMainBinding
import com.example.homework21_tms.presentation.view.auth.LoginFragment
import com.example.homework21_tms.presentation.view.auth.OnBoardingFragment
import com.example.homework21_tms.presentation.view.home.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MainView, NavController.OnDestinationChangedListener {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    private lateinit var navHostFragment: NavHostFragment

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        actionBar?.setDisplayHomeAsUpEnabled(false)

        mainPresenter.setView(this)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController

        mainPresenter.checkUserExistsAndSawOnboard()

// боттом навигейшен
        navController.addOnDestinationChangedListener(this)

        binding.bottomNavigation.setupWithNavController(navController)

        val btnav = AppBarConfiguration(
            setOf(R.id.onBoardingFragment, R.id.itemsFragment)
        )

        NavigationUI.setupActionBarWithNavController(this, navController, btnav)

    }

    override fun userExistsAndSawOnboard(userExists: Boolean, userSaw: Boolean) {

        when (userExists) {
            false -> {
                val navGraph = navController.navInflater.inflate(R.navigation.auth_graph)
                navGraph.setStartDestination(R.id.loginFragment)
                navController.graph = navGraph
            }
            true -> when (userSaw) {
                true -> navController.setGraph(R.navigation.home_graph)
                false -> {
                    val navGraph = navController.navInflater.inflate(R.navigation.auth_graph)
                    navGraph.setStartDestination(R.id.onBoardingFragment)
                    navController.graph = navGraph
                }
            }
        }
    }



    // боттом навигейшен

    override fun setStatusVisibility(destination: NavDestination) {

            if (destination.id == R.id.loginFragment || destination.id == R.id.onBoardingFragment) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }


    }



    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        mainPresenter.statusVisibility(destination)
    }

    override fun onDestroy() {
        super.onDestroy()
        navController.removeOnDestinationChangedListener(this)
    }


}