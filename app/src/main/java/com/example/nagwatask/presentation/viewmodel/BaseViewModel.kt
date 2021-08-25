package com.example.nagwatask.presentation.viewmodel

import android.annotation.SuppressLint
import androidx.core.util.Preconditions
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer

open class BaseViewModel(private val subscribeOn: Scheduler, private val observeOn: Scheduler) :
    ViewModel() {
    private val disposables: CompositeDisposable = CompositeDisposable()

    @SuppressLint("RestrictedApi")
    protected fun <T> execute(
        loadingConsumer: Consumer<Disposable>,
        successConsumer: Consumer<T>,
        throwableConsumer: Consumer<Throwable>,
        useCase: Observable<T>
    ) {
        Preconditions.checkNotNull(successConsumer)
        Preconditions.checkNotNull(throwableConsumer)
        val observable = useCase
            .doOnSubscribe(loadingConsumer)
            .subscribeOn(subscribeOn)
            .observeOn(observeOn)
        addDisposable(observable.subscribe(successConsumer, throwableConsumer))
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    protected fun dispose(disposable: Disposable?) {
        disposables.remove(disposable!!)
    }

    protected fun disposeAll() {
        disposables.clear()
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    @SuppressLint("RestrictedApi")
    private fun addDisposable(disposable: Disposable) {
        Preconditions.checkNotNull(disposable)
        Preconditions.checkNotNull(disposables)
        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        dispose()
    }
}
