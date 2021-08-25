package com.example.nagwatask.presentation.di

import androidx.lifecycle.ViewModel
import com.example.nagwatask.presentation.viewmodel.HomeViewModel
import com.example.nagwatask.presentation.viewmodel_factory.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindsHomeViewModel(homeViewModel: HomeViewModel) : ViewModel
}
