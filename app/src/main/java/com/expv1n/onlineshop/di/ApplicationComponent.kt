package com.expv1n.onlineshop.di

import android.app.Application
import com.expv1n.onlineshop.presentation.*
import dagger.BindsInstance
import dagger.Component

@Component(modules = [DataModule::class, ViewModelModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: LoginFragment)

    fun inject(fragment: SignInPageFragment)

    fun inject(fragment: Page1Fragment)


    @Component.Factory
    interface ApplicationComponentFactory {
        fun create(@BindsInstance application: Application): ApplicationComponent
    }
}