package com.example.nagwatask.domin.di

import com.example.nagwatask.data.di.DataComponent
import com.example.nagwatask.data.di.NetModule
import com.example.nagwatask.domin.usecase.GetMaterialsUseCase
import dagger.Component

@DomainScope
@Component(modules = [UseCaseModule::class, NetModule::class], dependencies = [DataComponent::class])
interface DomainComponent {
    fun getMaterialsUseCase() : GetMaterialsUseCase
}