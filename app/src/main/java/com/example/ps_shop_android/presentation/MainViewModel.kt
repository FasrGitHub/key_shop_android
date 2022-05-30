package com.example.ps_shop_android.presentation

import androidx.lifecycle.ViewModel
import com.example.ps_shop_android.data.ProductRepositoryImpl
import com.example.ps_shop_android.domain.usecase.GetAllProductsUseCase

class MainViewModel: ViewModel() {

    //TODO неверная реализация возможно через иньекцию зависимости
    private val repository = ProductRepositoryImpl

    private val getAllProductsUseCase = GetAllProductsUseCase(repository)

    val productList = getAllProductsUseCase.getAllProducts()
}