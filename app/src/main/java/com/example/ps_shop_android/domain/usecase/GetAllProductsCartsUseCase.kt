package com.example.ps_shop_android.domain.usecase

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.domain.models.Product
import com.example.ps_shop_android.domain.repository.CartRepository

class GetAllProductsCartsUseCase(private val cartRepository: CartRepository) {

    fun getAllProductsCarts(): LiveData<List<Product>> {
        return cartRepository.getAllProductsCarts()
    }
}