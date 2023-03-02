package com.expv1n.onlineshop.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.models.Latest

class LatestDiffCallback: DiffUtil.ItemCallback<com.example.domain.models.Latest>() {

    override fun areItemsTheSame(oldItem: com.example.domain.models.Latest, newItem: com.example.domain.models.Latest): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: com.example.domain.models.Latest, newItem: com.example.domain.models.Latest): Boolean {
        return oldItem == newItem
    }
}