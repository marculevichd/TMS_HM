package com.example.homework21_tms.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.homework21_tms.databinding.ItemFaveBinding
import com.example.homework21_tms.domain.model.FaveModel

class FaveViewHolder(
    private val viewBinding: ItemFaveBinding
) : RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(faveModel: FaveModel) {
        viewBinding.tvID.text = faveModel.id.toString()
        viewBinding.tvPersonName.text = faveModel.name
        viewBinding.tvUserName.text = faveModel.username
        viewBinding.tvEmail.text = faveModel.email
        viewBinding.tvPhone.text = faveModel.phone
        viewBinding.tvWebsite.text = faveModel.website
        viewBinding.tvStreet.text = faveModel.addressStreet
        viewBinding.tvSuite.text = faveModel.addressSuite
        viewBinding.tvCity.text = faveModel.addressCity
        viewBinding.tvZipcode.text = faveModel.addressZipcode
        viewBinding.tvLat.text = faveModel.geoLat
        viewBinding.tvLng.text = faveModel.geoLng
        viewBinding.tvCompanyName.text = faveModel.companyName
        viewBinding.tvCatchPhrase.text = faveModel.companyCatchPhrase
        viewBinding.tvBS.text = faveModel.companyBs
    }

}