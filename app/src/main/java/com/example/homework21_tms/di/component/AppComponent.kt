package com.example.homework21_tms.di.component

import com.example.homework21_tms.di.*
import com.example.homework21_tms.di.factory.ScreenScope
import com.example.homework21_tms.presentation.view.MainActivity
import com.example.homework21_tms.presentation.view.auth.LoginFragment
import com.example.homework21_tms.presentation.view.auth.OnBoardingFragment
import com.example.homework21_tms.presentation.view.home.*
import dagger.Component


@Component(
    modules = [
        AppModule::class,
        DataBaseModule::class,
        DataModule::class,
        DomainModule::class,
        PresentationModule::class
    ]
)

@ScreenScope
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(fragment: LoginFragment)
    fun inject(fragment: OnBoardingFragment)
    fun inject(fragment: HomeFragment)
    fun inject(fragment: ItemsFragment)
    fun inject(fragment: DetailsFragment)
    fun inject(fragment: FaveFragment)
    fun inject(fragment: RetrofitExampleFragment)

}