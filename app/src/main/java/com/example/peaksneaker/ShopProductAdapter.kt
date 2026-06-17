package com.example.peaksneaker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ShopProductAdapter(private val productList: List<ShopProduct>) : RecyclerView.Adapter<ShopProductAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduct: ImageView = itemView.findViewById(R.id.imgProduct)
        val txtBadge: TextView = itemView.findViewById(R.id.txtBadge)
        val cardBadge: CardView = itemView.findViewById(R.id.cardBadge)
        val txtBrand: TextView = itemView.findViewById(R.id.txtBrand)
        val txtName: TextView = itemView.findViewById(R.id.txtName)
        val txtPrice: TextView = itemView.findViewById(R.id.txtPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.imgProduct.setImageResource(product.imageResId)
        holder.txtBadge.text = product.badge
        holder.cardBadge.setCardBackgroundColor(Color.parseColor(product.badgeColor))
        holder.txtBrand.text = product.brand
        holder.txtName.text = product.name
        holder.txtPrice.text = product.price
    }

    override fun getItemCount(): Int = productList.size
}