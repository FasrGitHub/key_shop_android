package com.example.ps_shop_android.domain.repository

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.domain.models.Product

interface CartRepository {

    fun addProductCart(product: Product)

    fun deleteProductCart(product: Product)

    fun getAllProductsCarts(): LiveData<List<Product>>
}