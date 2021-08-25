package com.example.nagwatask.domin.usecase

import com.example.nagwatask.data.remote.response.MaterialResponse
import com.example.nagwatask.domin.Resource
import io.reactivex.Observable

interface GetMaterialsUseCase {
    fun execute() : Observable<Resource<MaterialResponse?>>
}
