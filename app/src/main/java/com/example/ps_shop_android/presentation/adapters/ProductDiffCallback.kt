package com.example.ps_shop_android.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.ps_shop_android.domain.pojo.Product

class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {

    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }
}