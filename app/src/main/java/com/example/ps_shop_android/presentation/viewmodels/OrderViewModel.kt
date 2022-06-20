package com.example.ps_shop_android.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.usecase.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class OrderViewModel @Inject constructor(
    private val getAllProductsCartsUseCase: GetAllProductsCartsUseCase,
    private val deleteProductCartUseCase: DeleteProductCartUseCase,
    private val getSumPriceCartUseCase: GetSumPriceCartUseCase,
    private val getJsonResponseUseCase: GetJsonResponseUseCase,
    private val deleteAllProductsCartUseCase: DeleteAllProductsCartUseCase,
) : ViewModel() {

    private val _errorInputEmail = MutableLiveData<Boolean>()
    val errorInputEmail: LiveData<Boolean>
        get() = _errorInputEmail

    private val _errorInputWallet = MutableLiveData<Boolean>()
    val errorInputWallet: LiveData<Boolean>
        get() = _errorInputWallet

    val productCartList = getAllProductsCartsUseCase()


    fun deleteAllProductsCart() {
        viewModelScope.launch {
            deleteAllProductsCartUseCase()
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

    fun getJsonResponse(inputEmail: String?, inputWallet: String?, productsList: List<Product>) {
        val email = parseEmail(inputEmail)
        val wallet = parseWallet(inputWallet)
        val fieldsValid = validateInput(email, wallet)
        if (fieldsValid) {
            getJsonResponseUseCase(email, wallet, productsList)
        }
    }

    private fun parseEmail(inputEmail: String?): String {
        return inputEmail?.trim() ?: ""
    }

    private fun parseWallet(inputWallet: String?): String {
        return inputWallet?.trim() ?: ""
    }

    private fun validateInput(email: String, wallet: String): Boolean {
        var result = true
        if (email.isBlank()) {
            _errorInputEmail.value = true
            result = false
        }
        if (wallet.isBlank()) {
            _errorInputWallet.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputEmail() {
        _errorInputEmail.value = false
    }

    fun resetErrorInputWallet() {
        _errorInputWallet.value = false
    }
}