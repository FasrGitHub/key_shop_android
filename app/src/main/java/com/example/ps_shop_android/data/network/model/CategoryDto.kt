package com.example.ps_shop_android.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryDto(

    @SerializedName("username")
    @Expose
    val title: String? = null,
) {
}