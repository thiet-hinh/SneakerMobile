package com.example.peaksneaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ProductAdapter(private val list: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtName: TextView = view.findViewById(R.id.txtProductName)
        val txtBrand: TextView = view.findViewById(R.id.txtBrand)
        val tagProduct: TextView = view.findViewById(R.id.tagProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = list[position]
        holder.txtName.text = product.name
        holder.txtBrand.text = product.brand
        holder.tagProduct.text = product.tag
    }

    override fun getItemCount() = list.size
}