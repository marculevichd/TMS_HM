package com.example.homework21_tms.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

object NavHelper {

    fun Fragment.navigate(destinationId: Int) {
        findNavController().navigate(destinationId)
    }


    fun Fragment.navigateWithBundle(destinationId: Int, bundle: Bundle) {
        findNavController().navigate(destinationId, bundle)
    }

    fun Fragment.replaceGraph(destinationGraph: Int) {
        findNavController().setGraph(destinationGraph)
    }

    fun Fragment.navigateWithDeleteBackStack(destinationId: Int, fragmentToDelete: Int) {
        val navOption = NavOptions.Builder()
        navOption.setPopUpTo(fragmentToDelete, true)
        findNavController().navigate(destinationId, null, navOption.build())
    }

}