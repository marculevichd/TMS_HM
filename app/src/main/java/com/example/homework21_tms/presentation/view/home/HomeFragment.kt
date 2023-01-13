package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentHomeBinding
import com.example.homework21_tms.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {


    private val homeViewModel: HomeViewModel by viewModels()

    private var _viewBinding: FragmentHomeBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentHomeBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.showUserCreds()
        homeViewModel.userCreds.observe(viewLifecycleOwner) {
            viewBinding.homeTV.text = "${it.userName}"
        }

        viewBinding.homeButton.setOnClickListener {
            homeViewModel.nav()
            homeViewModel.nav.observe(viewLifecycleOwner) {
                navigate(it!!)
            }
        }
    }
}