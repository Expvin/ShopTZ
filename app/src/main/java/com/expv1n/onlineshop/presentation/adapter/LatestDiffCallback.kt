package com.expv1n.onlineshop.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.expv1n.onlineshop.domain.models.Latest

class LatestDiffCallback: DiffUtil.ItemCallback<Latest>() {

    override fun areItemsTheSame(oldItem: Latest, newItem: Latest): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Latest, newItem: Latest): Boolean {
        return oldItem == newItem
    }
}