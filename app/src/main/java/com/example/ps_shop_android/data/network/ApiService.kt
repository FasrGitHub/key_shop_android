package com.example.ps_shop_android.data.network

import com.example.ps_shop_android.data.network.model.ProductDto
import com.example.ps_shop_android.domain.model.Category
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun getCategoriesList(): List<Category>

    @GET("/posts")
    suspend fun getProductsList(): List<ProductDto>
}