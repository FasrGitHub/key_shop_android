package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.repository.CartRepository

class AreThereProductsListUseCase(private val cartRepository: CartRepository) {

    fun areThereProductsList() : Boolean  {
        return cartRepository.areThereProductsList()
    }
}