package com.taskandroid.framework.remote

import javax.inject.Inject


class ApiDataSource @Inject constructor() : SafeApiRequest() {


    private val TAG = ApiDataSource::class.java.simpleName

    @Inject
    lateinit var apiService: APIService

    suspend fun fetchIngredients(
    ) = getResult { apiService.fetchIngredients() }

    suspend fun fetchOrders(
    ) = getResult { apiService.fetchOrders() }


}

