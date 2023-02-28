package com.expv1n.onlineshop.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.expv1n.onlineshop.domain.models.FlashSale

class FlashSaleDiffCallback: DiffUtil.ItemCallback<FlashSale>() {
    override fun areItemsTheSame(oldItem: FlashSale, newItem: FlashSale): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: FlashSale, newItem: FlashSale): Boolean {
        return oldItem == newItem
    }
}