package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentDetailsBinding
import com.example.homework21_tms.databinding.FragmentHomeBinding
import com.example.homework21_tms.domain.model.WorkManagerModel
import com.example.homework21_tms.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(), HomeView {

    private var _viewBinding: FragmentHomeBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentHomeBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.setView(this)


        viewBinding.goToItemsFragment.setOnClickListener {
            navigate(R.id.action_homeFragment_to_itemsFragment)
        }

        viewBinding.goToRetrofitFragment.setOnClickListener {
            navigate(R.id.action_homeFragment_to_retrofitExampleFragment)
        }

        viewBinding.button2.setOnClickListener {
            navigate(R.id.action_homeFragment_to_faveFragment)
        }


    }

    override fun showStringData(string: WorkManagerModel) {
        viewBinding.homeTextViewForWorkmanager.text = string.string
    }

}