package com.taskandroid.framework.remote

import com.taskandroid.entities.Addon
import com.taskandroid.entities.Order
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("api.php")
    suspend fun fetchOrders(
    ): Response<Order>

    @GET("api.php")
    suspend fun fetchIngredients(
    ): Response<Addon>
}