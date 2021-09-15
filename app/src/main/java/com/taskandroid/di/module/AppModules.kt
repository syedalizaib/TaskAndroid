package com.taskandroid.di.module


import com.taskandroid.ui.ingredients.IngredientsViewModel
import com.taskandroid.ui.orders.OrdersViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModules = module {
    viewModel {
        OrdersViewModel()
    }
    viewModel {
        IngredientsViewModel()
    }

}