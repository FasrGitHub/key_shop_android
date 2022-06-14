package com.example.ps_shop_android.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.ps_shop_android.R
import com.example.ps_shop_android.domain.model.Product
import com.example.ps_shop_android.presentation.adapters.ProductCartAdapter.ProductViewHolder

class ProductCartAdapter : ListAdapter<Product, ProductViewHolder>(ProductDiffCallback()) {

    var onProductClickListener: ((Product) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_product_cart_info,
            parent,
            false
        )
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = getItem(position)
        holder.tvName.text = product.name
        holder.tvDescription.text = product.description
        holder.tvPrice.text = product.price.toString()
        holder.buttonDeleteFromCart.setOnClickListener {
            onProductClickListener?.invoke(product)
        }
    }

    class ProductViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name_game)
        val tvDescription = view.findViewById<TextView>(R.id.tv_description_game)
        val tvPrice = view.findViewById<TextView>(R.id.tv_price)
        val buttonDeleteFromCart = view.findViewById<Button>(R.id.button_delete_from_cart)
    }
}