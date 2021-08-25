package com.example.nagwatask.data.repository.materials

import com.example.nagwatask.data.remote.ApiServices
import com.example.nagwatask.data.remote.response.MaterialResponse
import com.example.nagwatask.domin.Resource
import com.example.nagwatask.domin.mappers.ResourceMapper
import io.reactivex.Single
import retrofit2.Response
import javax.inject.Inject

class MaterialsRepoImpl @Inject constructor(
    private val apiServices: ApiServices,
    private val resourceMapper: ResourceMapper<MaterialResponse>
    ) : MaterialsRepo {
    override fun getMaterials(): Single<Resource<MaterialResponse?>> =
        apiServices.getMaterials().map(resourceMapper::map)
}