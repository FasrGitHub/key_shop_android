package com.example.ps_shop_android.data.api

import com.example.ps_shop_android.domain.pojo.Category
import com.example.ps_shop_android.domain.pojo.Product
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("/users")
    fun getCategoriesList(): Single<List<Category>>

    @GET("/posts")
    fun getProductsList(): Single<List<Product>>

    companion object {
        private const val QUERY_PARAM_ID = "id"
        private const val QUERY_PARAM_USERNAME = "username"

        private const val QUERY_PARAM_ID_CATEGORY_PRODUCT = "userId"
        private const val QUERY_PARAM_NAME = "title"
        private const val QUERY_PARAM_DESCRIPTION = "body"
    }
}