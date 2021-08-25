package com.example.nagwatask.presentation.viewmodel_factory.di

import androidx.lifecycle.ViewModelProvider
import com.example.nagwatask.presentation.di.ViewModelsModule
import com.icon.tamapp.presentation.di.PresentationScope
import com.example.nagwatask.presentation.viewmodel_factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module(includes = [ViewModelsModule::class, SchedulersModule::class])
interface ViewModelFactoryModule {

    @Binds
    @PresentationScope
    fun provideViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

}
