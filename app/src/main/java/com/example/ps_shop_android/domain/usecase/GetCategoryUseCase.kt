package com.example.ps_shop_android.domain.usecase

import com.example.ps_shop_android.domain.repository.ProductRepository

class GetCategoryUseCase(private val productRepository: ProductRepository) {

    operator fun invoke() = productRepository.getCategory()
}