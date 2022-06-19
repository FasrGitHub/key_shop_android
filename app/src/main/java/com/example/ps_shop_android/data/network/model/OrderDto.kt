package com.example.ps_shop_android.data.network.model

import com.example.ps_shop_android.domain.model.Product
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class OrderDto(
    @SerializedName("inputEmail")
    @Expose
    val inputEmail: String,
    @SerializedName("inputWallet")
    @Expose
    val inputWallet: String,
    @SerializedName("productsList")
    @Expose
    val productsList: List<Product>
)