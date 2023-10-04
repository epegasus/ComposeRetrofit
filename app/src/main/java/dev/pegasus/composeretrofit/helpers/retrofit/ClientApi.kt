package dev.pegasus.composeretrofit.helpers.retrofit

import dev.pegasus.composeretrofit.helpers.models.DataItem
import retrofit2.http.GET

interface ClientApi {

    @GET("posts")
    suspend fun getData(): List<DataItem>

}