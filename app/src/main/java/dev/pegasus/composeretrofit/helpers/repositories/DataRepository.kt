package dev.pegasus.composeretrofit.helpers.repositories

import dev.pegasus.composeretrofit.helpers.models.DataItem
import dev.pegasus.composeretrofit.helpers.retrofit.RetrofitInstance

class DataRepository {

    suspend fun getResult(): List<DataItem> {
        return RetrofitInstance.clientApi.getData()
    }
}