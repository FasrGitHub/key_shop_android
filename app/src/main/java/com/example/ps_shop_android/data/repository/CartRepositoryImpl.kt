package com.example.ps_shop_android.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.ps_shop_android.data.database.CartDao
import com.example.ps_shop_android.data.mapper.ProductMapper
import com.example.ps_shop_android.data.network.model.OrderDto
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.repository.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val mapper: ProductMapper,
    private val cartDao: CartDao,
) : CartRepository {

    override suspend fun addProductCart(product: Product) {
        cartDao.addProductToCart(
            mapper.mapEntityToCartDbModel(product)
        )
    }

    override suspend fun deleteProductCart(product: Product) {
        cartDao.deleteProductFromCart(
            mapper.mapEntityToCartDbModel(product)
        )
    }

    override suspend fun deleteAllProductsCart() {
        cartDao.deleteAllProductsCart()
    }

    override fun getAllProductsCart(): LiveData<List<Product>> {
        return Transformations.map(cartDao.getAllProductsCart()) {
            it.map {
                mapper.mapCartDbModelToEntity(it)
            }
        }
    }

    override fun getSumPriceCart(productsList: List<Product>): Int {
        var sum = 0
        return if (productsList.isEmpty()){
            sum
        } else {
            for (product in productsList){
                sum += product.price!!
            }
            sum
        }
    }

    override fun getJsonResponse(
        inputEmail: String,
        inputWallet: String,
        productsList: List<Product>
    ) {
        val orderDto = OrderDto(inputEmail, inputWallet, productsList)
        Log.d("getJsonResponse", "input $orderDto")
    }
}