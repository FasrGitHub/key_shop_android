package com.example.ps_shop_android.presentation

import android.widget.EditText
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ps_shop_android.data.CartRepositoryImpl
import com.example.ps_shop_android.data.ProductRepositoryImpl
import com.example.ps_shop_android.domain.models.Product
import com.example.ps_shop_android.domain.usecase.*

class MainViewModel: ViewModel() {

    //TODO неверная реализация возможно через иньекцию зависимости
    private val productRepository = ProductRepositoryImpl
    private val cartRepository = CartRepositoryImpl

    private val getAllProductsUseCase = GetAllProductsUseCase(productRepository)
    private val getAllProductsCartsUseCase = GetAllProductsCartsUseCase(cartRepository)
    private val areThereProductsListUseCase = AreThereProductsListUseCase(cartRepository)
    private val addProductCartUseCase = AddProductCartUseCase(cartRepository)
    private val deleteProductCartUseCase = DeleteProductCartUseCase(cartRepository)
    private val getSumPriceCartUseCase = GetSumPriceCartUseCase(cartRepository)

    val productCartList = getAllProductsCartsUseCase.getAllProductsCarts()

    val productList = getAllProductsUseCase.getAllProducts()

    fun addProductCart(product: Product) {
        addProductCartUseCase.addProductCart(product)
    }
    fun getSumPriceCart(): Int{
        return getSumPriceCartUseCase.getSumPriceCart()
    }

    fun areThereProductsList(): Boolean {
        return areThereProductsListUseCase.areThereProductsList()
    }

    fun deleteProductCart(product: Product) {
        deleteProductCartUseCase.deleteProductCart(product)
    }
}