package com.example.nagwatask.presentation.viewmodel_factory.di

import dagger.Module
import javax.inject.Named
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

@Module
class SchedulersModule {

    @Provides
    @Named(value = IO_SCHEDULER)
    internal fun bindIoScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @Named(value = MAIN_THREAD_SCHEDULER)
    internal fun bindMainThreadScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    companion object Const{
        const val IO_SCHEDULER = "IO_SCHEDULER"
        const val MAIN_THREAD_SCHEDULER = "MAIN_THREAD_SCHEDULER"
    }

}
