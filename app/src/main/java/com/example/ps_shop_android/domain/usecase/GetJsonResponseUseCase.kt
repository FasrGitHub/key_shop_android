package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.repository.CartRepository
import javax.inject.Inject

class GetJsonResponseUseCase @Inject constructor(
    private val cartRepository: CartRepository
)  {
    operator fun invoke(
        inputEmail: String,
        inputWallet: String,
        productsList: List<Product>
    ) = cartRepository.getJsonResponse(inputEmail, inputWallet, productsList)
}