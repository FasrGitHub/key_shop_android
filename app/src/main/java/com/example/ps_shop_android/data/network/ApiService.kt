package com.example.ps_shop_android.data.network

import com.example.ps_shop_android.data.network.model.OrderDto
import com.example.ps_shop_android.data.network.model.ProductDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/posts")
    suspend fun getProductsList(): List<ProductDto>

    @POST()
    fun postOrder(@Body orderDto: OrderDto)
}