package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.repository.CartRepository

class GetSumPriceCartUseCase(private val cartRepository: CartRepository) {

    fun getSumPriceCart() : Int {
        return cartRepository.getSumPriceCart()
    }
}