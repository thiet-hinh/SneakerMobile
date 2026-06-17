package com.example.peaksneaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// 1. Data Class
data class SearchProduct(
    val id: Int,
    val name: String,
    val brand: String,
    val price: String,
    val imageResId: Int
)

// 2. Adapter
class SearchResultAdapter(private val products: List<SearchProduct>) :
    RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgProduct: ImageView = view.findViewById(R.id.imgProduct)
        val txtBrand: TextView = view.findViewById(R.id.txtBrand)
        val txtName: TextView = view.findViewById(R.id.txtName)
        val txtPrice: TextView = view.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_search_result, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products[position]
        holder.txtBrand.text = product.brand
        holder.txtName.text = product.name
        holder.txtPrice.text = product.price
        holder.imgProduct.setImageResource(product.imageResId)
    }

    override fun getItemCount() = products.size
}