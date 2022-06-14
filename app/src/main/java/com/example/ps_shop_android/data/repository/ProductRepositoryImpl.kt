package com.example.ps_shop_android.data.repository

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ps_shop_android.data.mapper.ProductMapper
import com.example.ps_shop_android.data.network.ApiFactory.apiService
import com.example.ps_shop_android.domain.model.Category
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.repository.ProductRepository


object ProductRepositoryImpl : ProductRepository {

    private val categoriesListLD = MutableLiveData<List<Category>>()
    private var categoriesList = mutableListOf<Category>()

    private val productsListLD = MutableLiveData<List<Product>>()
    private var productsList = mutableListOf<Product>()

    private val mapper = ProductMapper()

//    init {
//        //TODO переделать json запрос!!!
//        ApiFactory.apiService.getCategoriesList()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                categoriesList = it as MutableList<Category>
//                updateProductsList()
//                Log.d("TEST", it.toString())
//            }, {
//                Log.d("Error", it.message.toString())
//            })
//
//        ApiFactory.apiService.getProductsList()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                productsList = it as MutableList<Product>
//                updateProductsList()
//                Log.d("TEST", it.toString())
//            }, {
//                Log.d("Error", it.message.toString())
//            })
//    }

    override fun getAllCategories(): LiveData<List<Category>> {
        return categoriesListLD
    }

    override fun getAllProducts(): LiveData<List<Product>> {
        return productsListLD
    }

    override fun getCategory() {
        TODO("Not yet implemented")
    }

    override fun addProduct(product: Product) {
        productsList.add(product)
        updateProductsList()
    }

    private fun updateCategoriesList() {
        categoriesListLD.value = categoriesList.toList()
    }

    private fun updateProductsList() {
        productsListLD.value = productsList.toList()
    }

    override suspend fun loadData() {
        try {
            val productsDtoList = apiService.getProductsList()
            productsDtoList.map {
                addProduct(mapper.mapDtoToEntity(it))
                Log.d("TEST", productsList.toString())
            }

        } catch (e: Exception) {
        }
    }
}