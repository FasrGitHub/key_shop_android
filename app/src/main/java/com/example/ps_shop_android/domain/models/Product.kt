package com.example.ps_shop_android.domain.models

data class Product(
    val name: String,
    val picture: String,
    val description: String,
    val price: Int,
    val categoryId: Int,
    var id: Int = UNDEFINED_ID,
) {
    companion object{
        const val UNDEFINED_ID = -1
    }
}