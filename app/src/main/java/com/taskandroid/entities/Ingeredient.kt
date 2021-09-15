package com.taskandroid.entities

import com.google.gson.annotations.SerializedName


data class Ingeredient(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("quantity")
    var quantity: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("available")
    var available: Boolean,
) {

}