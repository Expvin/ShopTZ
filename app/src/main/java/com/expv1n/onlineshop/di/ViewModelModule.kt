package com.expv1n.onlineshop.di

import androidx.lifecycle.ViewModel
import com.expv1n.onlineshop.presentation.viewmodel.LoginFragmentViewModel
import com.expv1n.onlineshop.presentation.viewmodel.Page1FragmentViewModel
import com.expv1n.onlineshop.presentation.viewmodel.SingInPageFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @IntoMap
    @Binds
    @ViewModelKey(LoginFragmentViewModel::class)
    fun bindLoginFragmentViewModel(impl: LoginFragmentViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(Page1FragmentViewModel::class)
    fun bindPage1FragmentViewModel(impl: Page1FragmentViewModel): ViewModel

    @IntoMap
    @Binds
    @ViewModelKey(SingInPageFragmentViewModel::class)
    fun bindSingInPageFragmentViewModel(impl: SingInPageFragmentViewModel): ViewModel

}