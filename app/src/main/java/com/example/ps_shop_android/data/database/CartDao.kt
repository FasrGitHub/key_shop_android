package com.example.ps_shop_android.data.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CartDao {

    @Query("SELECT * FROM products_cart_list")
    fun getAllProductsCart(): LiveData<List<ProductDbModel>>

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun addProductToCart(productDbModel: ProductDbModel)
//
//    @Delete
//    fun deleteProductFromCart(productDb: ProductDbModel)
}