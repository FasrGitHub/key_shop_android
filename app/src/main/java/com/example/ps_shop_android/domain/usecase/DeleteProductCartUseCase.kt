package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.repository.CartRepository
import javax.inject.Inject

class DeleteProductCartUseCase @Inject constructor(
    private val cartRepository: CartRepository
    ) {

    suspend operator fun invoke(product: Product) = cartRepository.deleteProductCart(product)
}