package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentItemsBinding
import com.example.homework21_tms.domain.model.ItemsModel
import com.example.homework21_tms.presentation.adapter.ItemsAdapter
import com.example.homework21_tms.presentation.adapter.listener.ItemListener
import com.example.homework21_tms.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    lateinit var itemsAdapter: ItemsAdapter

    @Inject
    lateinit var itemsPresenter: ItemPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)


        viewBinding.recyclerView.adapter = itemsAdapter
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(context)

        itemsPresenter.getData()
    }


    override fun onClick() {
        itemsPresenter.imageViewClicked()
    }

    override fun onElementSelected(
        title_listener: String,
        description_listener: Int,
        time_listener: String,
        image_listener: Int
    ) {
        itemsPresenter.elementSelected(title_listener, description_listener, time_listener, image_listener)
    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(ivClicked: Int) {
        Toast.makeText(context, "just a message", Toast.LENGTH_SHORT).show()
    }

    override fun goToDetails(navigationData:NavigateWithBundle) {
        val bundle = Bundle()
        bundle.putString("title_listener", navigationData.title)
        bundle.putInt("description_listener", navigationData.description)
        bundle.putString("time_listener", navigationData.time)
        bundle.putInt("image_listener", navigationData.image)

        navigateWithBundle(R.id.action_itemsFragment_to_detailsFragment, bundle)

    }
}