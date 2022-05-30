package com.example.ps_shop_android.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ps_shop_android.domain.models.Category
import com.example.ps_shop_android.domain.models.Product
import com.example.ps_shop_android.domain.repository.ProductRepository

object ProductRepositoryImpl: ProductRepository {

    private val categoriesListLD = MutableLiveData<List<Category>>()
    private val categoriesList = mutableListOf<Category>()

    private val productsListLD = MutableLiveData<List<Product>>()
    private val productsList = mutableListOf<Product>()

    private var autoIncrementProductId = 0

    init {
        for (i in 0 until 1000) {
            val product = Product(
                "Test $i",
                "test",
                "TestTestTest$i",
                i,
                i
            )
            addProduct(product)
        }
    }

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
        product.id = autoIncrementProductId++
        productsList.add(product)
        updateProductsList()
    }

    private fun updateCategoriesList() {
        categoriesListLD.value = categoriesList.toList()
    }

    private fun updateProductsList() {
        productsListLD.value = productsList.toList()
    }
}