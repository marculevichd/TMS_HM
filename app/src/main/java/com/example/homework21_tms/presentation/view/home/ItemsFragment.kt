package com.example.homework21_tms.presentation.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
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
class ItemsFragment : Fragment(), ItemListener {

    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    lateinit var itemsAdapter: ItemsAdapter

    private val itemsViewModel: ItemViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)


        viewBinding.recyclerView.adapter = itemsAdapter
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(context)

        itemsViewModel.getData()

        itemsViewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }


        itemsViewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        itemsViewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val bundle = Bundle()
                bundle.putString("title_listener", navBundle.title)
                bundle.putInt("description_listener", navBundle.description)
                bundle.putString("time_listener", navBundle.time)
                bundle.putInt("image_listener", navBundle.image)

                navigateWithBundle(navBundle.destinationId, bundle)
            }
        }
    }

    override fun onClick() {
        itemsViewModel.imageViewClicked()
        itemsViewModel.userNavigated()
    }

    override fun onElementSelected(
        title_listener: String,
        description_listener: Int,
        time_listener: String,
        image_listener: Int
    ) {
        itemsViewModel.elementSelected(
            title_listener,
            description_listener,
            time_listener,
            image_listener
        )
    }
}