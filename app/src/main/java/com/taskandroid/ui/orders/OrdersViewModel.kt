package com.taskandroid.ui.orders

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taskandroid.entities.Addon
import com.taskandroid.entities.Order
import com.viewtraksol.kyriopos.utils.GeneralUtils

class OrdersViewModel() : ViewModel() {


    val orderList: MutableLiveData<ArrayList<Order>> = MutableLiveData()


    fun createOrdersData() {
        orderList.value = arrayListOf(
            Order(
                id = 1,
                title = "Special extra large fried rice",
                quantity = 2,
                created_at = GeneralUtils.getDateTimeWithThreshold(0),
                alerted_at = GeneralUtils.getDateTimeWithThreshold(3),
                expired_at = GeneralUtils.getDateTimeWithThreshold(5),
                addon = arrayListOf(
                    Addon(
                        id = 1,
                        title = "Nasi Lemak",
                        quantity = 2
                    ),
                    Addon(
                        id = 2,
                        title = "Nasi Lemak",
                        quantity = 1
                    )
                )
            ),
            Order(
                id = 2,
                title = "Chicken Noodle",
                quantity = 1,
                created_at = GeneralUtils.getDateTimeWithThreshold(-2),
                alerted_at = GeneralUtils.getDateTimeWithThreshold(1),
                expired_at = GeneralUtils.getDateTimeWithThreshold(3),
                addon = arrayListOf(
                    Addon(
                        id = 1,
                        title = "Nasi Lemak",
                        quantity = 2
                    ),
                    Addon(
                        id = 2,
                        title = "Nasi Lemak",
                        quantity = 1
                    ), Addon(
                        id = 1,
                        title = "Nasi Lemak",
                        quantity = 2
                    )
                )
            ),
            Order(
                id = 3,
                title = "Special extra large fried rice",
                quantity = 1,
                created_at = GeneralUtils.getDateTimeWithThreshold(-4),
                alerted_at = GeneralUtils.getDateTimeWithThreshold(-1),
                expired_at = GeneralUtils.getDateTimeWithThreshold(1),
                addon = arrayListOf(
                    Addon(
                        id = 1,
                        title = "Nasi Lemak",
                        quantity = 2
                    ),
                    Addon(
                        id = 2,
                        title = "Nasi Lemak",
                        quantity = 1
                    )
                )
            )
        )
    }
}