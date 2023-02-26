package com.expv1n.onlineshop.domain.models

data class FlashSale(
    val category: String,
    val discount: Int,
    val image_url: String,
    val name: String,
    val price: Double
)