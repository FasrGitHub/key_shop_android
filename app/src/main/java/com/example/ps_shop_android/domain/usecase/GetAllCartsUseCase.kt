package com.example.ps_shop_android.domain.usecase

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.domain.models.Cart
import com.example.ps_shop_android.domain.repository.CartRepository

class GetAllCartsUseCase(private val cartRepository: CartRepository) {

    fun getAllCarts(): LiveData<List<Cart>> {
        return cartRepository.getAllCarts()
    }
}