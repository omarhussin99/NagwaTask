package com.example.nagwatask.presentation.di

import com.example.nagwatask.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeActivityBindingModule {
    @ContributesAndroidInjector(modules = [HomeFragmentsBindingModule::class])
    abstract fun provideHomeActivity(): MainActivity
}
