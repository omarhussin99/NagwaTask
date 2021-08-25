package com.example.nagwatask.data.di

import com.example.nagwatask.data.repository.materials.MaterialsRepo
import com.example.nagwatask.data.repository.materials.MaterialsRepoImpl
import dagger.Binds
import dagger.Module

@Module(includes = [NetModule::class])
interface RepoModule {
    @Binds
    fun bindMaterialsRepo(materialsRepoImpl: MaterialsRepoImpl) : MaterialsRepo
}