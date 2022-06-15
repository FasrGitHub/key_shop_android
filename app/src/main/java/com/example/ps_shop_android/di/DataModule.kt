package com.example.ps_shop_android.di

import android.app.Application
import com.example.ps_shop_android.data.database.CartDao
import com.example.ps_shop_android.data.database.CartDatabase
import com.example.ps_shop_android.data.database.ProductDao
import com.example.ps_shop_android.data.database.ProductDatabase
import com.example.ps_shop_android.data.repository.CartRepositoryImpl
import com.example.ps_shop_android.data.repository.ProductRepositoryImpl
import com.example.ps_shop_android.domain.repository.CartRepository
import com.example.ps_shop_android.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindProductRepository(impl: ProductRepositoryImpl): ProductRepository

    @Binds
    fun bindCartRepository(impl: CartRepositoryImpl): CartRepository

    companion object {

        @Provides
        fun provideProductDao(
            application: Application
        ): ProductDao {
            return ProductDatabase.getInstance(application).productDao()
        }

        @Provides
        fun provideCartDao(
            application: Application
        ): CartDao {
            return CartDatabase.getInstance(application).cartDao()
        }
    }
}