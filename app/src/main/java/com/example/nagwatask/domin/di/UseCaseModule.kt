package com.example.nagwatask.domin.di

import com.example.nagwatask.data.di.NetModule
import com.example.nagwatask.domin.usecase.GetMaterialsUseCase
import com.example.nagwatask.domin.usecase.GetMaterialsUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetModule::class])
interface UseCaseModule {
    @Binds
    fun bindsGetMaterialsUseCase(getMaterialsUseCaseImpl: GetMaterialsUseCaseImpl) : GetMaterialsUseCase
}
