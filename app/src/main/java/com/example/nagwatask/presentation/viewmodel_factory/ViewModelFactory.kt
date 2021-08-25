package com.example.nagwatask.presentation.viewmodel_factory

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject
constructor(private val viewModelMap: Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    @SuppressWarnings("SuspiciousMethodCalls", "unchecked")
    @NonNull
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val provider = viewModelMap[modelClass]
        val entries = viewModelMap.entries
        for ((key) in entries) {
            if (key.isAssignableFrom(modelClass)) {
                return provider!!.get() as T
            }
        }
        throw IllegalArgumentException("unknown model class $modelClass")
    }
}