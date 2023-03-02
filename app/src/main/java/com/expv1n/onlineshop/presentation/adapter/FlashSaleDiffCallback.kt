package com.expv1n.onlineshop.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.FlashSale

class FlashSaleDiffCallback: DiffUtil.ItemCallback<com.example.domain.models.FlashSale>() {
    override fun areItemsTheSame(oldItem: com.example.domain.models.FlashSale, newItem: com.example.domain.models.FlashSale): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: com.example.domain.models.FlashSale, newItem: com.example.domain.models.FlashSale): Boolean {
        return oldItem == newItem
    }
}