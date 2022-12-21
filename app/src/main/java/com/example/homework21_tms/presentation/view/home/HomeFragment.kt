package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentHomeBinding
import com.example.homework21_tms.databinding.FragmentLoginBinding
import com.example.homework21_tms.presentation.view.auth.LoginPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
    lateinit var homePresenter: HomePresenter


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.showUserData()
        homePresenter.userCreds.observe(viewLifecycleOwner){
            binding.homeTv.text = "${it.userName} \n ${it.userPassword}"
        }



        binding.buttonNextPage.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, ItemsFragment())
                .addToBackStack("")
                .commit()
        }


    }


}