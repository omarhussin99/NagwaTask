package com.example.nagwatask.domin.mappers

import android.util.Log
import com.example.nagwatask.domin.Resource
import com.google.gson.GsonBuilder
import retrofit2.Response
import javax.inject.Inject

class ResourceMapper<DATA> @Inject constructor() {

    fun map(response: Response<DATA>): Resource<DATA?> {
        var r = Resource.success(response.body())
        when {
            response.body() == 200 -> {
                r = Resource.success(response.body())
            }
            response.body() == 409 -> {
                val errorMsg = response.message()
                r = Resource.apiError(errorMsg, response.code())
            }
            response.code() != 200 -> {
                val errorMsg = response.message()
                r = Resource.apiError(errorMsg, response.code())
            }
        }
        Log.d("RESPONSE", GsonBuilder().setPrettyPrinting().create().toJson(response.body()))
        return r
    }


}