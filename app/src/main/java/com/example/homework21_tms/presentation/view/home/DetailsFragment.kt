package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentDetailsBinding
import com.example.homework21_tms.presentation.view.auth.LoginFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment() {


    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        bundle?.let { safeBundle ->

            viewBinding.titleDetails.text = safeBundle.getString("title_listener")
            viewBinding.descriptionDetails.setText(safeBundle.getInt("description_listener"))
            viewBinding.timeDetails.text = safeBundle.getString("time_listener")
            viewBinding.imageDetails.setBackgroundResource(safeBundle.getInt("image_listener"))
        }


        viewBinding.buttonLogout.setOnClickListener {
            detailsPresenter.logoutUser()
        }

        detailsPresenter.userLogout.observe(viewLifecycleOwner) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, LoginFragment()).commit()
        }
    }
}