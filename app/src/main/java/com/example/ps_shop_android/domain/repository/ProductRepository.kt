package com.example.ps_shop_android.domain.repository

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.domain.model.Category
import com.example.ps_shop_android.domain.model.Product

interface ProductRepository {

    fun getAllCategories(): LiveData<List<Category>>

    fun getAllProducts(): LiveData<List<Product>>

    fun getCategory()

    fun addProduct(product: Product)

    suspend fun loadData()
}