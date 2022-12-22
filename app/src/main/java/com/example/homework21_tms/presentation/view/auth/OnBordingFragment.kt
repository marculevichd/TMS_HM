package com.example.homework21_tms.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentOnBordingBinding
import com.example.homework21_tms.presentation.view.home.HomeFragment
import com.example.homework21_tms.presentation.view.home.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBordingFragment : Fragment() {

    @Inject
    lateinit var onBoardPresenter: OnBoardingPresenter

    private var _viewBinding: FragmentOnBordingBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBordingBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.descOnbord.text

        viewBinding.btnOnbord.setOnClickListener {


            onBoardPresenter.saveOnBoard(true)



            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, HomeFragment())
                .commit()
        }
    }


}