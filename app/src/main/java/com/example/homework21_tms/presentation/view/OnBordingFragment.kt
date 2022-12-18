package com.example.homework21_tms.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentOnBordingBinding


class OnBordingFragment : Fragment() {


    private var _viewBinding: FragmentOnBordingBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentOnBordingBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewBinding.btnOnbord.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, ItemsFragment())
                .commit()
        }
    }


}