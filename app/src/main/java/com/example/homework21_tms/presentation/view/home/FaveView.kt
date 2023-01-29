package com.example.homework21_tms.presentation.view.home

import com.example.homework21_tms.domain.model.FaveModel

interface FaveView {

    suspend fun getFavorites(list: List<FaveModel>)

}