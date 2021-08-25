package com.example.nagwatask.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nagwatask.data.remote.response.MaterialResponse
import com.example.nagwatask.domin.Resource
import com.example.nagwatask.domin.usecase.GetMaterialsUseCase
import com.example.nagwatask.presentation.viewmodel_factory.di.SchedulersModule
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named

class HomeViewModel @Inject constructor(
    @Named(SchedulersModule.IO_SCHEDULER) val subscribeOn: Scheduler,
    @Named(SchedulersModule.MAIN_THREAD_SCHEDULER) val observeOn: Scheduler,
    private val getMaterialsUseCase: GetMaterialsUseCase
    ) : BaseViewModel(subscribeOn, observeOn){

    private val materialsMutableLiveData:MutableLiveData<Resource<MaterialResponse?>> = MutableLiveData()

    fun getMaterials(){
        try {
            execute(
                { materialsMutableLiveData.postValue(Resource.loading()) },
                {
                    if (it.status == Resource.Status.SUCCESS) {
                        materialsMutableLiveData.postValue(Resource.success(it.data))
                    } else {
                        materialsMutableLiveData.postValue(
                            Resource.apiError(it.error_msg, it.responseCode)
                        )
                    }
                },
                { throwable: Throwable ->
                    materialsMutableLiveData.postValue(Resource.domainError(throwable))
                },
                getMaterialsUseCase.execute()
            )
        } catch (e: Exception) {
            materialsMutableLiveData.postValue(Resource.domainError(e))
        }
    }

    fun fetchMaterialsLiveData():LiveData<Resource<MaterialResponse?>> = materialsMutableLiveData
}