package com.example.homework21_tms.di

import com.example.homework21_tms.domain.auth.AuthInteractor
import com.example.homework21_tms.domain.home.ItemInteractor
import com.example.homework21_tms.domain.home.RetrofitExampleInteractor
import com.example.homework21_tms.presentation.view.MainPresenter
import com.example.homework21_tms.presentation.view.auth.LoginPresenter
import com.example.homework21_tms.presentation.view.auth.OnBoardingPresenter
import com.example.homework21_tms.presentation.view.home.DetailsPresenter
import com.example.homework21_tms.presentation.view.home.HomePresenter
import com.example.homework21_tms.presentation.view.home.ItemPresenter
import com.example.homework21_tms.presentation.view.home.RetrofitExamplePresenter
import dagger.Module
import dagger.Provides


@Module
class PresentationModule {
    @Provides
    fun provideMainPresenter(authInteractor: AuthInteractor): MainPresenter {
        return MainPresenter(authInteractor)
    }

    @Provides
    fun provideLoginPresenter(authInteractor: AuthInteractor): LoginPresenter {
        return LoginPresenter(authInteractor)
    }

    @Provides
    fun provideOnBoardingPresenter(authInteractor: AuthInteractor): OnBoardingPresenter {
        return OnBoardingPresenter(authInteractor)
    }

    @Provides
    fun provideItemsPresenter(itemInteractor: ItemInteractor): ItemPresenter {
        return ItemPresenter(itemInteractor)
    }

    @Provides
    fun provideDetailsPresenter(authInteractor: AuthInteractor): DetailsPresenter {
        return DetailsPresenter(authInteractor)
    }

    @Provides
    fun provideHomePresenter(): HomePresenter {
        return HomePresenter()
    }

    @Provides
    fun provideRetrofitExamplePresenter(retrofitExampleInteractor: RetrofitExampleInteractor): RetrofitExamplePresenter {
        return RetrofitExamplePresenter(retrofitExampleInteractor)
    }

}