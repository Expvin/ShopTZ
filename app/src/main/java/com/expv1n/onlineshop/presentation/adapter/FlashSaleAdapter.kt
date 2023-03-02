package com.expv1n.onlineshop.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.expv1n.onlineshop.databinding.FlashSaleItemBinding
import com.example.domain.models.FlashSale


class FlashSaleAdapter: ListAdapter<com.example.domain.models.FlashSale, FlashSaleAdapter.FlashSaleViewHolder>
    (FlashSaleDiffCallback()) {

    class FlashSaleViewHolder(val binding: FlashSaleItemBinding):
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashSaleViewHolder {
        val binding = FlashSaleItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return FlashSaleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlashSaleViewHolder, position: Int) {
        val flashSale = getItem(position)
        holder.itemView.apply {
            Glide.with(this).load(flashSale.image_url).into(holder.binding.itemLatestImageView)
        }
        holder.binding.itemRectanglesTextView.text = flashSale.category
        holder.binding.itemNameTextView.text = flashSale.name
        holder.binding.itemPriceTextView.text = flashSale.price.toString()
        holder.binding.itemSaleTextView.text = flashSale.discount.toString()
    }

}