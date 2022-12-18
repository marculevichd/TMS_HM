package com.example.homework21_tms.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.homework21_tms.R
import com.example.homework21_tms.data.ItemRepositoryImpl
import com.example.homework21_tms.databinding.FragmentItemsBinding
import com.example.homework21_tms.domain.ItemInteractor
import com.example.homework21_tms.model.ItemsModel
import com.example.homework21_tms.presentation.adapter.ItemsAdapter
import com.example.homework21_tms.presentation.adapter.listener.ItemListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemListener, ItemsView {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!


    private lateinit var itemsAdapter: ItemsAdapter
    lateinit var itemsPresenter: ItemPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsPresenter = ItemPresenter(this, ItemInteractor(ItemRepositoryImpl()))

        itemsAdapter = ItemsAdapter(this)


        viewBinding.recyclerView.adapter = itemsAdapter

        // надо передать лист
        itemsPresenter.getData()

    }


    override fun onClick() {
        itemsPresenter.imageViewClicked()
//        Toast.makeText(context, "click", Toast.LENGTH_SHORT).show()
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

    override fun goToDetails(title: String, description: Int, time: String, image: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("title_listener", title)
        bundle.putInt("description_listener", description)
        bundle.putString("time_listener", time)
        bundle.putInt("image_listener", image)
        detailsFragment.arguments = bundle

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.activity_container, detailsFragment)
            .addToBackStack("")
            .commit()


    }
}