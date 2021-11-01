package ru.llxodz.pizzahouse.api

import retrofit2.Response
import retrofit2.http.GET
import java.io.IOException

interface ApiRequest {

    @GET("/promoCodes")
    suspend fun getPromoCodes(): Response<List<ApiSalesItem>>
}
