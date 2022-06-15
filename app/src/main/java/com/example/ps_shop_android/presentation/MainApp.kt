package com.example.ps_shop_android.presentation

import android.app.Application
import com.example.ps_shop_android.di.DaggerApplicationComponent

class MainApp : Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}