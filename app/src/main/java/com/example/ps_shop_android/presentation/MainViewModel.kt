package com.example.ps_shop_android.presentation

import androidx.lifecycle.ViewModel
import com.example.ps_shop_android.data.CartRepositoryImpl
import com.example.ps_shop_android.data.ProductRepositoryImpl
import com.example.ps_shop_android.domain.models.Product
import com.example.ps_shop_android.domain.usecase.AddProductCartUseCase
import com.example.ps_shop_android.domain.usecase.GetAllProductsCartsUseCase
import com.example.ps_shop_android.domain.usecase.GetAllProductsUseCase

class MainViewModel: ViewModel() {

    //TODO неверная реализация возможно через иньекцию зависимости
    private val productRepository = ProductRepositoryImpl
    private val cartRepository = CartRepositoryImpl

    private val getAllProductsUseCase = GetAllProductsUseCase(productRepository)
    private val getAllProductsCartsUseCase = GetAllProductsCartsUseCase(cartRepository)
    private val addProductCartUseCase = AddProductCartUseCase(cartRepository)

    val productCartList = getAllProductsCartsUseCase.getAllProductsCarts()

    val productList = getAllProductsUseCase.getAllProducts()

    fun addCart(product: Product) {
        addProductCartUseCase.addProductCart(product)
    }
}