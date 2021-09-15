package com.taskandroid.entities

import com.google.gson.annotations.SerializedName

data class Addon(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("quantity")
    var quantity: Int,
) {
}