package com.example.ps_shop_android.domain.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("title")
    @Expose
    val name: String? = null,
    val picture: String? = null,
    @SerializedName("body")
    @Expose
    val description: String? = null,
    val price: Int = 1000,
    @SerializedName("userId")
    @Expose
    val categoryId: Int? = null,
    @SerializedName("id")
    @Expose
    var id: Int = UNDEFINED_ID,
) {
    companion object{
        const val UNDEFINED_ID = -1
    }
}