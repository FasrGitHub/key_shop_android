package com.example.ps_shop_android.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ps_shop_android.domain.models.Product
import com.example.ps_shop_android.domain.repository.CartRepository

object CartRepositoryImpl: CartRepository {

    private val cartProductListLD = MutableLiveData<List<Product>>()
    private val cartProductList = mutableListOf<Product>()

    override fun addProductCart(product: Product) {
        cartProductList.add(product)
        updateCartList()
    }

    override fun deleteProductCart(product: Product) {
        cartProductList.remove(product)
        updateCartList()
    }

    override fun getAllProductsCarts(): LiveData<List<Product>> {
        return cartProductListLD
    }

    private fun updateCartList() {
        cartProductListLD.value = cartProductList.toList()
    }
}