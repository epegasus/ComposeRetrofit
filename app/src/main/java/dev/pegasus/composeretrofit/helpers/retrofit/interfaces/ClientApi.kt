package dev.pegasus.composeretrofit.helpers.retrofit.interfaces

import dev.pegasus.composeretrofit.helpers.retrofit.models.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ClientApi {

    @GET("products?limit=10")
    suspend fun getData(@Query("skip") count: Int): Response<Result>

}