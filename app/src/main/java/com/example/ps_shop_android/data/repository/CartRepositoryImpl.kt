package com.example.ps_shop_android.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.ps_shop_android.data.database.CartDao
import com.example.ps_shop_android.data.mapper.ProductMapper
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.repository.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(
    private val mapper: ProductMapper,
    private val cartDao: CartDao,
) : CartRepository {

    override fun addProductCart(product: Product) {
//        cartDao.addProductToCart(
//            mapper.mapEntityToDbModel(product)
//        )
    }

    override fun deleteProductCart(product: Product) {
//        cartDao.deleteProductFromCart(
//            mapper.mapEntityToDbModel(product)
//        )
    }

    override fun getAllProductsCarts(): LiveData<List<Product>> {
        return Transformations.map(cartDao.getAllProductsCart()) {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun areThereProductsList(): Boolean {
//        return cartProductListLD.value.isNullOrEmpty()
        return true
    }

    override fun getSumPriceCart(): Int {
        var sum = 0
//        return if (areThereProductsList()) {
//            sum
//        } else { for (product in cartProductList.iterator()) sum += product.price
//            sum
//        }
        return sum
    }

    override fun getJsonResponse() {

    }
}