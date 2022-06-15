package com.example.ps_shop_android.data.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.ps_shop_android.data.database.ProductDao
import com.example.ps_shop_android.data.database.ProductDbModel
import com.example.ps_shop_android.data.mapper.ProductMapper
import com.example.ps_shop_android.data.network.ApiFactory.apiService
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val mapper: ProductMapper,
    private val productDao: ProductDao
) : ProductRepository {

    override fun getAllProducts(): LiveData<List<Product>> {
        return Transformations.map(productDao.getAllProducts()) {
            it.map {
                mapper.mapDbModelToEntity(it)
            }
        }
    }

    override fun addProduct(productDb: ProductDbModel) {
        Log.d("ProductRepositoryImpl", "addProduct1 $productDb")
        productDao.addProduct(productDb)
        Log.d("ProductRepositoryImpl", "addProduct2")
    }

    override suspend fun loadData() {
        try {
            Log.d("ProductRepositoryImpl", "loadData1")
            val productsDtoList = apiService.getProductsList()
            productsDtoList.map {
                addProduct(mapper.mapDtoToDbModel(it))
            }
            Log.d("ProductRepositoryImpl", "loadData2")
        } catch (e: Exception) {
            Log.d("ProductRepositoryImpl", "loadDataERROR")
        }
    }
}