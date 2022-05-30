package com.example.ps_shop_android.domain.usecase

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.domain.models.Category
import com.example.ps_shop_android.domain.repository.ProductRepository

class GetAllCategoriesUseCase(private val productRepository: ProductRepository) {

    fun getAllCategories(): LiveData<List<Category>> {
        return productRepository.getAllCategories()
    }
}