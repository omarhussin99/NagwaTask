package com.example.nagwatask.presentation.di

import com.example.nagwatask.presentation.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentsBindingModule {
    @ContributesAndroidInjector
    abstract fun provideHomeFragment(): HomeFragment
}
