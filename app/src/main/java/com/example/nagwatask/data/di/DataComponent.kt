package com.example.nagwatask.data.di

import android.content.Context
import com.example.nagwatask.data.repository.materials.MaterialsRepo
import com.icon.tamapp.data.di.DataScope
import dagger.BindsInstance
import dagger.Component

@DataScope
@Component(modules = [RepoModule::class])
interface DataComponent {
    fun materialRepo():MaterialsRepo

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder
        fun build(): DataComponent
    }
}