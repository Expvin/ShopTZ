package com.expv1n.onlineshop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.expv1n.onlineshop.databinding.LatestItemBinding
import com.expv1n.onlineshop.domain.models.Latest

class LatestAdapter: ListAdapter<Latest, LatestAdapter.LatestViewHolder>(LatestDiffCallback()) {

    class LatestViewHolder(val binding: LatestItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val binding = LatestItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LatestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val latest = getItem(position)
        holder.itemView.apply {
            Glide.with(this).load(latest.image_url).into(holder.binding.itemLatestImageView)
        }
        holder.binding.itemRectanglesTextView.text = latest.category
        holder.binding.itemNameTextView.text = latest.name
        holder.binding.itemPriceTextView.text = latest.price.toString()
    }

}