package com.example.ps_shop_android.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Query("SELECT * FROM products_list")
    fun getAllProducts(): LiveData<List<ProductDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduct(productDbModel: ProductDbModel)
}