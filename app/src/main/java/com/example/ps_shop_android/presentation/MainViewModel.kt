package com.example.ps_shop_android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ps_shop_android.data.repository.CartRepositoryImpl
import com.example.ps_shop_android.data.repository.ProductRepositoryImpl
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.usecase.*
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    //TODO неверная реализация возможно через иньекцию зависимости
    private val productRepository = ProductRepositoryImpl
    private val cartRepository = CartRepositoryImpl

    private val getAllProductsCartsUseCase = GetAllProductsCartsUseCase(cartRepository)
    private val areThereProductsListUseCase = AreThereProductsListUseCase(cartRepository)
    private val addProductCartUseCase = AddProductCartUseCase(cartRepository)
    private val deleteProductCartUseCase = DeleteProductCartUseCase(cartRepository)
    private val getSumPriceCartUseCase = GetSumPriceCartUseCase(cartRepository)

    private val getAllProductsUseCase = GetAllProductsUseCase(productRepository)
    private val loadDataUseCase = LoadDataUseCase(productRepository)

    // TODO делается запрос каждый раз когда создается view возможно сделать новую view model или
    // реализовать загрузку через worker
    init {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }

    val productCartList = getAllProductsCartsUseCase()

    val productList = getAllProductsUseCase()

    fun addProductCart(product: Product) {
        addProductCartUseCase(product)
    }
    fun getSumPriceCart(): Int{
        return getSumPriceCartUseCase()
    }

    fun areThereProductsList(): Boolean {
        return areThereProductsListUseCase()
    }

    fun deleteProductCart(product: Product) {
        deleteProductCartUseCase(product)
    }
}