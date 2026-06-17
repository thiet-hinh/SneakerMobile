package com.example.peaksneaker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ShopCategoryAdapter(private val categoryList: List<Category>) : RecyclerView.Adapter<ShopCategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardCategoryBg: CardView = itemView.findViewById(R.id.cardCategoryBg)
        val imgCategoryIcon: ImageView = itemView.findViewById(R.id.imgCategoryIcon)
        val txtCategoryName: TextView = itemView.findViewById(R.id.txtCategoryName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList[position]
        holder.txtCategoryName.text = category.name
        holder.imgCategoryIcon.setImageResource(category.iconResId)

        // Highlight mục đầu tiên ("Tất cả") thành màu Cam
        if (position == 0) {
            holder.cardCategoryBg.setCardBackgroundColor(Color.parseColor("#FF5E00"))
            holder.txtCategoryName.setTextColor(Color.parseColor("#FF5E00"))
            holder.imgCategoryIcon.setColorFilter(Color.WHITE)
        } else {
            holder.cardCategoryBg.setCardBackgroundColor(Color.parseColor("#1A1A1A"))
            holder.txtCategoryName.setTextColor(Color.parseColor("#888888"))
            holder.imgCategoryIcon.setColorFilter(Color.parseColor("#888888"))
        }
    }

    override fun getItemCount(): Int = categoryList.size
}