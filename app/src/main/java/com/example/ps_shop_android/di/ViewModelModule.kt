package com.example.ps_shop_android.di

import androidx.lifecycle.ViewModel
import com.example.ps_shop_android.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindCoinViewModule(viewModel: MainViewModel): ViewModel
}