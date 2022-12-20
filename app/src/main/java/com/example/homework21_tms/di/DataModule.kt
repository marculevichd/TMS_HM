package com.example.homework21_tms.di

import com.example.homework21_tms.data.ItemRepositoryImpl
import com.example.homework21_tms.domain.ItemRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindItemsRepository (itemsRepositoryImpl: ItemRepositoryImpl): ItemRepository
}