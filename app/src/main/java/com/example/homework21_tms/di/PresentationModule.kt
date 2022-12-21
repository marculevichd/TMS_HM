package com.example.homework21_tms.di

import com.example.homework21_tms.domain.ItemInteractor
import com.example.homework21_tms.presentation.view.home.ItemPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class PresentationModule {

    @Provides
    fun provideItemsPresenter(itemInteractor: ItemInteractor): ItemPresenter {
        return ItemPresenter(itemInteractor)
    }

}