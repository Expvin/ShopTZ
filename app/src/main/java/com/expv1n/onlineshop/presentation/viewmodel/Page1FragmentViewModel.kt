package com.expv1n.onlineshop.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.FlashSale
import com.example.domain.models.Latest
import com.example.domain.usecases.GetFlashSaleUseCase
import com.example.domain.usecases.GetLatestUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class Page1FragmentViewModel @Inject constructor(
    private val getLatest: GetLatestUseCase,
    private val getFlashSale: GetFlashSaleUseCase
) : ViewModel() {

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
                delay(1000)
                getFlashSale.getFlashSale()
            }
            _latestLiveDate.value = deferredLatest.await()
            _flashSaleLiveDate.value = deferredFlashSale.await()
        }
        job.join()
    }
}