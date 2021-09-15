package com.taskandroid.framework.repository

import com.taskandroid.entities.Addon
import com.taskandroid.entities.Order
import com.taskandroid.framework.Result
import com.taskandroid.framework.remote.ApiDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor() {

    private val TAG = Repository::class.java.simpleName

    @Inject
    lateinit var apiDataSource: ApiDataSource


    suspend fun fetchIngredients(
    ): Result<Addon> {
        return apiDataSource.fetchIngredients()
    }

    suspend fun fetchOrders(): Result<Order> {
        return apiDataSource.fetchOrders()
    }
}
