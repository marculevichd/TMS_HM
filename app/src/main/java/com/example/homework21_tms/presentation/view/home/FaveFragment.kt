package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentDetailsBinding
import com.example.homework21_tms.databinding.FragmentFaveBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FaveFragment : Fragment(), FaveView {


    private var _viewBinding: FragmentFaveBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var favePresenter: FavePresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentFaveBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}