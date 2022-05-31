package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.models.Product
import com.example.ps_shop_android.domain.repository.CartRepository

class DeleteProductCartUseCase(private val cartRepository: CartRepository) {

    fun deleteProductCart(product: Product){
        cartRepository.deleteProductCart(product)
    }
}