package com.example.ps_shop_android.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.usecase.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val addProductCartUseCase: AddProductCartUseCase,
    private val getAllProductsUseCase: GetAllProductsUseCase,
    private val loadDataUseCase: LoadDataUseCase,
) : ViewModel() {

    val productList = getAllProductsUseCase()

    // TODO возможно сделать новую view model или реализовать загрузку через worker
    fun loadData() {
        viewModelScope.launch {
            loadDataUseCase()
        }
    }

    fun addProductCart(product: Product) {
        viewModelScope.launch {
            addProductCartUseCase(product)
        }
    }
}