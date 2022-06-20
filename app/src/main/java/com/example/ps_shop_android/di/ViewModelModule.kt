package com.example.ps_shop_android.di

import androidx.lifecycle.ViewModel
import com.example.ps_shop_android.presentation.viewmodels.MainViewModel
import com.example.ps_shop_android.presentation.viewmodels.OrderViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModule(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(OrderViewModel::class)
    fun bindOrderViewModule(viewModel: OrderViewModel): ViewModel
}