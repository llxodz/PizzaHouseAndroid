package ru.llxodz.pizzahouse.api.request

import retrofit2.Response
import retrofit2.http.GET
import ru.llxodz.pizzahouse.api.data.ApiSalesItem

interface ApiRequest {

    @GET("/promoCodes")
    suspend fun getPromoCodes(): Response<List<ApiSalesItem>>
}
