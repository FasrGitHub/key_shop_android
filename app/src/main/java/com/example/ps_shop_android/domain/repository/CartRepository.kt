package com.example.ps_shop_android.domain.repository

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.domain.models.Cart

interface CartRepository {

    fun addCart(cart: Cart)

    fun deleteCart(cart: Cart)

    fun getAllCarts(): LiveData<List<Cart>>
}