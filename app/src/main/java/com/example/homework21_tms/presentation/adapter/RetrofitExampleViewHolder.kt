package com.example.homework21_tms.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.homework21_tms.databinding.ItemUsersFromJsonBinding
import com.example.homework21_tms.domain.model.RetrofitExampleModel
import com.example.homework21_tms.presentation.adapter.listener.RetrofitExampleListener

class RetrofitExampleViewHolder(
    private val viewBinding: ItemUsersFromJsonBinding,
    private val retrofitExampleListener: RetrofitExampleListener,
    ) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(retrofitExampleModel: RetrofitExampleModel) {
        viewBinding.tvID.text = "${retrofitExampleModel.id}"
        viewBinding.tvPersonName.text = retrofitExampleModel.name
        viewBinding.tvUserName.text = retrofitExampleModel.username
        viewBinding.tvEmail.text = retrofitExampleModel.email
        viewBinding.tvPhone.text = retrofitExampleModel.phone
        viewBinding.tvWebsite.text = retrofitExampleModel.website
        viewBinding.tvStreet.text = retrofitExampleModel.addressStreet
        viewBinding.tvSuite.text = retrofitExampleModel.addressSuite
        viewBinding.tvCity.text = retrofitExampleModel.addressCity
        viewBinding.tvZipcode.text = retrofitExampleModel.addressZipcode
        viewBinding.tvLat.text = retrofitExampleModel.geoLat
        viewBinding.tvLng.text = retrofitExampleModel.geoLng
        viewBinding.tvCompanyName.text = retrofitExampleModel.companyName
        viewBinding.tvCatchPhrase.text = retrofitExampleModel.companyCatchPhrase
        viewBinding.tvBS.text = retrofitExampleModel.companyBs

        viewBinding.addFave.setOnClickListener{
            retrofitExampleListener.onFavImageClicked(retrofitExampleModel.id)
        }


    }





}