package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentDetailsBinding
import com.example.homework21_tms.databinding.FragmentFaveBinding
import com.example.homework21_tms.domain.model.FaveModel
import com.example.homework21_tms.presentation.adapter.FaveAdapter
import com.example.homework21_tms.utils.NavHelper.navigate
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FaveFragment : Fragment(), FaveView {


    private var _viewBinding: FragmentFaveBinding? = null
    private val viewBinding get() = _viewBinding!!
    lateinit var faveAdapter: FaveAdapter

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

        favePresenter.setView(this)


        faveAdapter = FaveAdapter()
        viewBinding.recyclerViewFaves.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.recyclerViewFaves.adapter = faveAdapter

        favePresenter.getFavorites()






    }

    override suspend fun getFavorites(list: List<FaveModel>) {
        faveAdapter.submitList(list)
    }

}