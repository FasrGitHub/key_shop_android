package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.repository.CartRepository

class AddProductCartUseCase(private val cartRepository: CartRepository) {

    operator fun invoke(product: Product) = cartRepository.addProductCart(product)
}