package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.pojo.Product
import com.example.ps_shop_android.domain.repository.CartRepository

class AddProductCartUseCase(private val cartRepository: CartRepository) {

    fun addProductCart(product: Product){
        cartRepository.addProductCart(product)
    }
}