package com.example.ps_shop_android.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ps_shop_android.domain.models.Cart
import com.example.ps_shop_android.domain.repository.CartRepository

object CartRepositoryImpl: CartRepository {

    private val cartListLD = MutableLiveData<List<Cart>>()
    private val cartList = mutableListOf<Cart>()

    override fun addCart(cart: Cart) {
        cartList.add(cart)
        updateCartList()
    }

    override fun deleteCart(cart: Cart) {
        cartList.remove(cart)
        updateCartList()
    }

    override fun getAllCarts(): LiveData<List<Cart>> {
        return cartListLD
    }

    private fun updateCartList() {
        cartListLD.value = cartList.toList()
    }
}