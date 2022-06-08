package com.example.ps_shop_android.domain.usecase

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.domain.pojo.Product
import com.example.ps_shop_android.domain.repository.ProductRepository

class GetAllProductsUseCase(private val productRepository: ProductRepository) {

    fun getAllProducts(): LiveData<List<Product>> {
        return productRepository.getAllProducts()
    }
}