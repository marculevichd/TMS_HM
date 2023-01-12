package com.example.homework21_tms.presentation.view.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentOnBordingBinding
import com.example.homework21_tms.domain.model.UserModel
import com.example.homework21_tms.presentation.view.home.ItemsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment(), OnBoardingView {


    private var _viewBinding: FragmentOnBordingBinding? = null
    private val viewBinding get() = _viewBinding!!


    @Inject
    lateinit var onBoardingPresenter: OnBoardingPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentOnBordingBinding.inflate(inflater)
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
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, ItemsFragment())
            .commit()
    }

    override fun showUserCreds(userModel: UserModel) {
        viewBinding.descOnbord.text = "${userModel.name}"
    }
}