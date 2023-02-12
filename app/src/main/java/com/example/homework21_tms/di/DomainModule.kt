package com.example.homework21_tms.di

import com.example.homework21_tms.domain.auth.AuthInteractor
import com.example.homework21_tms.domain.auth.AuthRepository
import com.example.homework21_tms.domain.home.ItemInteractor
import com.example.homework21_tms.domain.home.ItemRepository
import com.example.homework21_tms.domain.home.RetrofitExampleInteractor
import com.example.homework21_tms.domain.home.RetrofitExampleRepository
import dagger.Module
import dagger.Provides


@Module
class DomainModule {

    @Provides
    fun provideItemInteractor (itemRepository: ItemRepository): ItemInteractor {
        return ItemInteractor(itemRepository)
    }

    @Provides
    fun provideAuthInteractor (authRepository: AuthRepository): AuthInteractor {
        return AuthInteractor(authRepository)
    }

    @Provides
    fun provideRetrofitExampleInteractor (retrofitExampleRepository: RetrofitExampleRepository): RetrofitExampleInteractor {
        return RetrofitExampleInteractor(retrofitExampleRepository)
    }

}