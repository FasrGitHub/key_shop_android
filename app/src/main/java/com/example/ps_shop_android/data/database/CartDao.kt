package com.example.ps_shop_android.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CartDao {

    @Query("SELECT * FROM products_cart_list")
    fun getAllProductsCart(): LiveData<List<CartDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProductToCart(cartDbModel: CartDbModel)

    @Delete
    suspend fun deleteProductFromCart(cartDb: CartDbModel)
}