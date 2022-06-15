package com.example.ps_shop_android.domain.repository

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.data.database.ProductDbModel
import com.example.ps_shop_android.domain.model.Product

interface ProductRepository {

    fun getAllProducts(): LiveData<List<Product>>

    suspend fun addProduct(productDb: ProductDbModel)

    suspend fun loadData()
}