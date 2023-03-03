package com.expv1n.onlineshop

import android.app.Application
import com.expv1n.onlineshop.di.DaggerApplicationComponent


class ShopApplication: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory()
            .create(this)
    }
}