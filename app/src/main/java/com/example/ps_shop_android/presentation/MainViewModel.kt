package com.example.ps_shop_android.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.usecase.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getAllProductsCartsUseCase: GetAllProductsCartsUseCase,
    private val addProductCartUseCase: AddProductCartUseCase,
    private val deleteProductCartUseCase: DeleteProductCartUseCase,
    private val getSumPriceCartUseCase: GetSumPriceCartUseCase,
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val loadDataUseCase: LoadDataUseCase,
) : ViewModel() {

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
        viewModelScope.launch {
            addProductCartUseCase(product)
        }
    }

    fun deleteProductCart(product: Product) {
        viewModelScope.launch {
            deleteProductCartUseCase(product)
        }
    }

    fun getSumPriceCart(productsList: List<Product>): Int {
        return getSumPriceCartUseCase(productsList)
    }
}