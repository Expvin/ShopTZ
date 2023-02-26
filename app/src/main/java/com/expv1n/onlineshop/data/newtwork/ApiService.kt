package com.expv1n.onlineshop.data.newtwork

import com.expv1n.onlineshop.domain.models.FlashSale
import com.expv1n.onlineshop.domain.models.Latest
import retrofit2.http.GET

interface ApiService {

    @GET("v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7")
    suspend fun getLatest(): List<Latest>

    @GET("v3/a9ceeb6e-416d-4352-bde6-2203416576ac")
    suspend fun getFlashSale(): List<FlashSale>

    companion object {
        private const val LU = "https://run.mocky.io/v3/cc0071a1-f06e-48fa-9e90-b1c2a61eaca7"
        private const val FSU = "https://run.mocky.io/v3/a9ceeb6e-416d-4352-bde6-2203416576ac"
    }
}
