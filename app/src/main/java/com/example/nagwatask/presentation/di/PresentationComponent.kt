package com.example.nagwatask.presentation.di

import com.example.nagwatask.BaseApp
import com.example.nagwatask.domin.di.DomainComponent
import com.example.nagwatask.presentation.viewmodel_factory.ViewModelFactory
import com.example.nagwatask.presentation.viewmodel_factory.di.ViewModelFactoryModule
import com.icon.tamapp.presentation.di.PresentationScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@Component(
    modules = [
        ViewModelFactoryModule::class,
        AndroidSupportInjectionModule::class,
        HomeActivityBindingModule::class],
    dependencies = [DomainComponent::class])
@PresentationScope
interface PresentationComponent : AndroidInjector<DaggerApplication> {
    fun viewModelFactory(): ViewModelFactory
    fun inject(app: BaseApp)
}
