package com.example.nagwatask.data.remote

import com.example.nagwatask.data.remote.response.MaterialResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("movies")
    fun getMaterials():Single<Response<MaterialResponse>>
}