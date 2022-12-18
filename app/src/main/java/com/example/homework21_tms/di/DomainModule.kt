package com.example.homework21_tms.di

import com.example.homework21_tms.data.ItemRepositoryImpl
import com.example.homework21_tms.domain.ItemInteractor
import com.example.homework21_tms.domain.ItemRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {

    fun provideItemInteractor (itemRepository: ItemRepository): ItemInteractor {
        return ItemInteractor(itemRepository)
    }

}