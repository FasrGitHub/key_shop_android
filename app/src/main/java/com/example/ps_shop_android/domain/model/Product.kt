package com.example.ps_shop_android.domain.model

data class Product(
    val name: String?,
    val picture: String?,
    val description: String?,
    val price: Int?,
    val categoryId: Int?,
    var id: Int,
) {
}