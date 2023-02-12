package com.example.homework21_tms.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.homework21_tms.App
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.ActivityMainBinding
import javax.inject.Inject

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


        (applicationContext as App).provideAppComponent().inject(this)

        mainPresenter.setView(this)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navController = navHostFragment.navController

        mainPresenter.checkUserExistsAndSawOnboard()

// боттом навигейшен
        binding.bottomNavigation.setupWithNavController(navController)

        navController.addOnDestinationChangedListener(this)

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
        mainPresenter.setStatusVisibility(destination)
    }


}