package com.example.homework21_tms.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentOnBoardingBinding
import com.example.homework21_tms.domain.model.UserModel
import com.example.homework21_tms.presentation.view.home.ItemsFragment
import com.example.homework21_tms.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(), OnBoardingView {


    private var _viewBinding: FragmentOnBoardingBinding? = null
    private val viewBinding get() = _viewBinding!!


    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBoardingBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onBoardingPresenter.setView(this)

        onBoardingPresenter.showUserCreds()


        viewBinding.btnOnbord.setOnClickListener {
            onBoardingPresenter.saveIfUserSaveOnBoard(boolean = true)
            onBoardingPresenter.goToNextFragment()
        }
    }

    override fun goToNextFragment() {
        replaceGraph(R.navigation.home_graph)
    }

    override fun showUserCreds(userModel: UserModel) {
        viewBinding.descOnbord.text = "${userModel.name}"
    }
}