package com.example.homework21_tms.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.homework21_tms.R
import com.example.homework21_tms.domain.ItemInteractor
import com.example.homework21_tms.domain.model.ItemsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    val itemInteractor: ItemInteractor
) : ViewModel() {


    private val _items = MutableLiveData<List<ItemsModel>>()
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle


    fun getData() {
        val listItems = itemInteractor.getData()
        _items.value = listItems
    }

    fun imageViewClicked() {
        _msg.value = R.string.iv_clicked
    }

    fun elementSelected(
        title: String,
        description: Int,
        time: String,
        image: Int
    ) {
        _bundle.value = NavigateWithBundle(title, description, time, image)
    }

    fun userNavigated() {
        _bundle.value = null
    }

}

data class NavigateWithBundle(
    val title: String,
    val description: Int,
    val time: String,
    val image: Int

)