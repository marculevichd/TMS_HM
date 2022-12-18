package com.example.homework21_tms.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {


    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val bundle = arguments
        bundle?.let { safeBundle ->

            val title = safeBundle.getString("title_listener")
            val description = safeBundle.getInt("description_listener")
            val time = safeBundle.getString("time_listener")
            val image = safeBundle.getInt("image_listener")

            viewBinding.titleDetails.text = title
            viewBinding.descriptionDetails.setText(description)
            viewBinding.timeDetails.text = time
            viewBinding.imageDetails.setBackgroundResource(image)
        }
    }
}