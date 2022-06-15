package com.example.ps_shop_android.di

import android.app.Application
import com.example.ps_shop_android.presentation.MainFragment
import com.example.ps_shop_android.presentation.OrderFormFragment
import com.example.ps_shop_android.presentation.ShoppingCartFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: MainFragment)

    fun inject(fragment: ShoppingCartFragment)

    fun inject(fragment: OrderFormFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}