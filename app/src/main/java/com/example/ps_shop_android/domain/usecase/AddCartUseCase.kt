package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.models.Cart
import com.example.ps_shop_android.domain.repository.CartRepository

class AddCartUseCase(private val cartRepository: CartRepository) {

    fun addCart(cart: Cart){
        cartRepository.addCart(cart)
    }
}