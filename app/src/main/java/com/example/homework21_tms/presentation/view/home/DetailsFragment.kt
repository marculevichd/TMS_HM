package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentDetailsBinding
import com.example.homework21_tms.presentation.view.auth.LoginFragment
import com.example.homework21_tms.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {


    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailsPresenter.setView(this)

        val bundle = arguments
        bundle?.let { safeBundle ->
            detailsPresenter.showDetailInfo(
                safeBundle.getString("title_listener").toString(),
                safeBundle.getInt("description_listener"),
                safeBundle.getString("time_listener").toString(),
                safeBundle.getInt("image_listener")
            )
        }

        viewBinding.button.setOnClickListener {
            detailsPresenter.logOutUser()
        }
    }

    override fun userLogOut() {
        replaceGraph(R.navigation.auth_graph)
    }

    override fun showDetailInfo(title: String, description: Int, time: String, image: Int) {
        viewBinding.titleDetails.text = title
        viewBinding.descriptionDetails.setText(description)
        viewBinding.timeDetails.text = time
        viewBinding.imageDetails.setBackgroundResource(image)
    }
}