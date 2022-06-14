package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.repository.ProductRepository

class LoadDataUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke() = productRepository.loadData()
}