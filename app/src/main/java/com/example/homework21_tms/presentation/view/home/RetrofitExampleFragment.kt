package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework21_tms.databinding.FragmentRetrofitExampleBinding
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import com.example.homework21_tms.presentation.adapter.RetrofitExampleAdapter
import com.example.homework21_tms.presentation.adapter.listener.RetrofitExampleListener
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RetrofitExampleFragment : Fragment(), RetrofitExampleView, RetrofitExampleListener {

    private var _viewBinding: FragmentRetrofitExampleBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var retrofitExamplePresenter: RetrofitExamplePresenter

    private lateinit var retrofitExampleAdapter: RetrofitExampleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentRetrofitExampleBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retrofitExamplePresenter.setView(this)

        retrofitExampleAdapter = RetrofitExampleAdapter(this)
        viewBinding.recyclerViewUsers.adapter = retrofitExampleAdapter
        viewBinding.recyclerViewUsers.layoutManager = LinearLayoutManager(context)

        retrofitExamplePresenter.getDataFromJson()

    }

    override fun showData(list:List<RetrofitExampleModel>) {
            retrofitExampleAdapter.submitList(list)
    }
    override fun onFavImageClicked(id: Int) {
        retrofitExamplePresenter.onFavImageClicked(id)
    }

    override fun onDeleteImageClicked(id: Int) {
        retrofitExamplePresenter.onDeleteImageClicked(id)
    }

}