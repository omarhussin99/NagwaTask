package com.example.nagwatask.data.repository.materials

import com.example.nagwatask.data.remote.response.MaterialResponse
import com.example.nagwatask.domin.Resource
import io.reactivex.Single

interface MaterialsRepo {
    fun getMaterials() : Single<Resource<MaterialResponse?>>
}