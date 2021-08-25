package com.example.nagwatask.domin.usecase

import com.example.nagwatask.data.remote.response.MaterialResponse
import com.example.nagwatask.data.repository.materials.MaterialsRepo
import com.example.nagwatask.domin.Resource
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class GetMaterialsUseCaseImpl @Inject constructor(
    private val materialsRepo: MaterialsRepo
    ) : GetMaterialsUseCase {
    override fun execute(): Observable<Resource<MaterialResponse?>> =
        materialsRepo.getMaterials().toObservable()
}