package com.example.ps_shop_android.domain.model

import android.provider.ContactsContract

data class Order(
    val email: String,
    val wallet: String,
    val products: List<Product>,
) {
}