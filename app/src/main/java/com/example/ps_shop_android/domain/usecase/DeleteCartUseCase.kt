package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.models.Cart
import com.example.ps_shop_android.domain.repository.CartRepository

class DeleteCartUseCase(private val cartRepository: CartRepository) {

    fun deleteCart(cart: Cart){
        cartRepository.deleteCart(cart)
    }
}