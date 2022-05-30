package com.example.ps_shop_android.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ps_shop_android.R
import com.example.ps_shop_android.domain.models.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var productList = listOf<Product>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_product_info,
            parent,
            false
        )
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.tvName.text = product.name
        holder.tvDescription.text = product.description
        holder.tvPrice.text = product.price.toString()
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val tvName = view.findViewById<TextView>(R.id.tv_name_game)
        val tvDescription = view.findViewById<TextView>(R.id.tv_description_game)
        val tvPrice = view.findViewById<TextView>(R.id.tv_price)
    }
}