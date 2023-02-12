package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework21_tms.App
import com.example.homework21_tms.databinding.FragmentFaveBinding
import com.example.homework21_tms.domain.model.FaveModel
import com.example.homework21_tms.presentation.adapter.FaveAdapter
import com.example.homework21_tms.presentation.adapter.listener.FaveListener
import javax.inject.Inject

class FaveFragment : Fragment(), FaveView, FaveListener {


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
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        favePresenter.setView(this)


        faveAdapter = FaveAdapter(this)
        viewBinding.recyclerViewFaves.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.recyclerViewFaves.adapter = faveAdapter

        favePresenter.getFavorites()






    }

    override suspend fun getFavorites(list: List<FaveModel>) {
        faveAdapter.submitList(list)
    }

    override fun onFavImageClickedDel(id: Int) {
        favePresenter.favCklickedDel(id)
    }

}