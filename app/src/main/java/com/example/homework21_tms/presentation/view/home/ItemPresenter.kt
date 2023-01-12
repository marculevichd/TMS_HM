package com.example.homework21_tms.presentation.view.home

import android.util.Log
import com.example.homework21_tms.R
import com.example.homework21_tms.domain.home.ItemInteractor
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ItemPresenter @Inject constructor(
    private val itemInteractor: ItemInteractor
) {

    private lateinit var itemsView: ItemsView

    fun setView(context: ItemsView) {
        itemsView = context
    }


    fun getData() {
            val listItems = itemInteractor.getData()
            itemsView.dataReceived(listItems)
            }

    fun imageViewClicked() {
        itemsView.imageViewClicked(R.string.iv_clicked)
    }

    fun elementSelected(
        title: String,
        description: Int,
        time: String,
        image: Int
    ) {
        itemsView.goToDetails(NavigateWithBundle(title, description, time, image))
    }

}

data class NavigateWithBundle(
    val title: String,
    val description: Int,
    val time: String,
    val image: Int
)