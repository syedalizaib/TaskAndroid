package com.taskandroid.entities

import com.google.gson.annotations.SerializedName

data class Order(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("quantity")
    var quantity: Int,
    @SerializedName("created_at")
    var created_at: String,
    @SerializedName("alerted_at")
    var alerted_at: String,
    @SerializedName("expired_at")
    var expired_at: String,
    @SerializedName("addon")
    var addon: ArrayList<Addon>
) {
    override fun equals(other: Any?): Boolean {
        return id == (other as Order).id
    }
}