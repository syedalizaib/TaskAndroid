package com.taskandroid.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taskandroid.framework.repository.Repository
import com.taskandroid.ui.ingredients.IngredientsViewModel
import com.taskandroid.ui.orders.OrdersViewModel
import javax.inject.Inject

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class ViewModelFactory @Inject constructor() : ViewModelProvider.Factory {
    @Inject
    lateinit var repository: Repository

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(OrdersViewModel::class.java) -> OrdersViewModel() as T
            modelClass.isAssignableFrom(IngredientsViewModel::class.java) -> IngredientsViewModel() as T
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
