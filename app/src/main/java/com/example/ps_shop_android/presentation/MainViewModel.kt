package com.example.ps_shop_android.presentation

import androidx.lifecycle.ViewModel
import com.example.ps_shop_android.data.CartRepositoryImpl
import com.example.ps_shop_android.data.ProductRepositoryImpl
import com.example.ps_shop_android.domain.models.Cart
import com.example.ps_shop_android.domain.usecase.AddCartUseCase
import com.example.ps_shop_android.domain.usecase.GetAllProductsUseCase

class MainViewModel: ViewModel() {

    //TODO неверная реализация возможно через иньекцию зависимости
    private val productRepository = ProductRepositoryImpl
    private val cartRepository = CartRepositoryImpl

    private val getAllProductsUseCase = GetAllProductsUseCase(productRepository)
    private val addCartUseCase = AddCartUseCase(cartRepository)

    val productList = getAllProductsUseCase.getAllProducts()

    fun addCart(cart: Cart) {
        addCartUseCase.addCart(cart)
    }
}