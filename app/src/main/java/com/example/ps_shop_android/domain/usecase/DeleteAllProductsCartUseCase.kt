package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.repository.CartRepository
import javax.inject.Inject

class DeleteAllProductsCartUseCase @Inject constructor(
    private val cartRepository: CartRepository
) {

    suspend operator fun invoke() = cartRepository.deleteAllProductsCart()
}