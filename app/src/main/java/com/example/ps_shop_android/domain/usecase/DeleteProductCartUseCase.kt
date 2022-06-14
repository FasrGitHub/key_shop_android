package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.repository.CartRepository

class DeleteProductCartUseCase(private val cartRepository: CartRepository) {

    operator fun invoke(product: Product) = cartRepository.deleteProductCart(product)
}