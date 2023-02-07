package com.example.homework21_tms.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.homework21_tms.R
import com.example.homework21_tms.databinding.ItemFaveBinding
import com.example.homework21_tms.domain.model.FaveModel
import com.example.homework21_tms.presentation.adapter.listener.FaveListener

class FaveViewHolder(
    private val viewBinding: ItemFaveBinding,
    private val faveListener: FaveListener
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
        viewBinding.delFave.setBackgroundResource(R.drawable.favorite_selected_background)
        viewBinding.delFave.isSelected = true


        viewBinding.delFave.setOnClickListener {
            faveListener.onFavImageClickedDel(faveModel.id)
        }
    }

}