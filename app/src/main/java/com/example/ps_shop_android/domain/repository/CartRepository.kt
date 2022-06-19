package com.example.ps_shop_android.domain.repository

import androidx.lifecycle.LiveData
import com.example.ps_shop_android.domain.model.Product

interface CartRepository {

    suspend fun addProductCart(product: Product)

    suspend fun deleteProductCart(product: Product)

    suspend fun deleteAllProductsCart()

    fun getAllProductsCart(): LiveData<List<Product>>

    fun getSumPriceCart(productsList: List<Product>): Int

    fun getJsonResponse(inputEmail: String, inputWallet: String, productsList: List<Product>)
}