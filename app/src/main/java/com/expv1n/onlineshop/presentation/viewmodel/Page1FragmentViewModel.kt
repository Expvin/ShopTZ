package com.expv1n.onlineshop.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.expv1n.onlineshop.data.RepositoryImpl
import com.expv1n.onlineshop.domain.models.FlashSale
import com.expv1n.onlineshop.domain.models.Latest
import com.expv1n.onlineshop.domain.usecases.GetFlashSaleUseCase
import com.expv1n.onlineshop.domain.usecases.GetLatestUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Page1FragmentViewModel(application: Application): AndroidViewModel(application) {

    private val repository = RepositoryImpl(application)
    private val getLatest = GetLatestUseCase(repository)
    private val getFlashSale = GetFlashSaleUseCase(repository)

    private val _latestLiveDate = MutableLiveData<List<Latest>>()
    val latestLiveDate: LiveData<List<Latest>>
        get() = _latestLiveDate

    private val _flashSaleLiveDate = MutableLiveData<List<FlashSale>>()
    val flashSaleLiveDate: LiveData<List<FlashSale>>
        get() = _flashSaleLiveDate


    suspend fun getData() {

        val job = viewModelScope.launch {
            val deferredLatest = viewModelScope.async { getLatest.getLatest() }
            val deferredFlashSale = viewModelScope.async {
                delay(5000)
                getFlashSale.getFlashSale() }
            _latestLiveDate.value = deferredLatest.await()
            _flashSaleLiveDate.value = deferredFlashSale.await()
        }
        job.join()
    }
}