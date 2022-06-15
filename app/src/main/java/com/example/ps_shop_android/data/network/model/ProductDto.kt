package com.example.ps_shop_android.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductDto(
    @SerializedName("id")
    @Expose
    var id: Int = UNDEFINED_ID,
    @SerializedName("title")
    @Expose
    val name: String? = "",
    val picture: String? = "",
    @SerializedName("body")
    @Expose
    val description: String? = "",
    val price: Int = 1000,
    @SerializedName("userId")
    @Expose
    val categoryId: Int? = UNDEFINED_ID,
) {
    companion object{
        const val UNDEFINED_ID = -1
    }
}