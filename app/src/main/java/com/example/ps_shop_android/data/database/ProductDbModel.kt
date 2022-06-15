package com.example.ps_shop_android.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_list")
data class ProductDbModel(
    @PrimaryKey
    val id: Int,
    val name: String?,
    val picture: String? ,
    val description: String?,
    val price: Int?,
    val categoryId: Int?,
)