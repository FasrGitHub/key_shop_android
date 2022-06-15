package com.example.ps_shop_android.data.network

import com.example.ps_shop_android.data.network.model.ProductDto
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    suspend fun getProductsList(): List<ProductDto>
}