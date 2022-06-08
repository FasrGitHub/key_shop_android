package com.example.ps_shop_android.domain.repository

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.domain.pojo.Product

interface CartRepository {

    fun addProductCart(product: Product)

    fun deleteProductCart(product: Product)

    fun getAllProductsCarts(): LiveData<List<Product>>

    fun areThereProductsList(): Boolean

    fun getSumPriceCart(): Int
}