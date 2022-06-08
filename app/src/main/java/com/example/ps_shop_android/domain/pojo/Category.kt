package com.example.ps_shop_android.domain.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("id")
    @Expose
    val id: Int? = null,
    @SerializedName("username")
    @Expose
    val title: String? = null,
) {
}