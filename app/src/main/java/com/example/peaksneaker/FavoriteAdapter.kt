package com.example.peaksneaker
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FavoriteAdapter(private val favoriteList: List<FavoriteProduct>) :
    RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

    class FavoriteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgFavProduct: ImageView = itemView.findViewById(R.id.imgFavProduct)
        val txtFavBrand: TextView = itemView.findViewById(R.id.txtFavBrand)
        val txtFavName: TextView = itemView.findViewById(R.id.txtFavName)
        val txtFavSize: TextView = itemView.findViewById(R.id.txtFavSize)
        val dotColor: View = itemView.findViewById(R.id.dotColor)
        val txtFavColor: TextView = itemView.findViewById(R.id.txtFavColor)
        val txtFavPrice: TextView = itemView.findViewById(R.id.txtFavPrice)
        val btnRemoveFav: ImageButton = itemView.findViewById(R.id.btnRemoveFav)
        val btnAddCart: ImageButton = itemView.findViewById(R.id.btnAddCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_favorite, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favoriteList[position]

        holder.txtFavBrand.text = item.brand
        holder.txtFavName.text = item.name
        holder.txtFavSize.text = "Size ${item.size}"
        holder.txtFavColor.text = item.colorName
        holder.txtFavPrice.text = item.price
        holder.imgFavProduct.setImageResource(item.imageRes)

        // Đổi màu sinh động cho dấu chấm tròn dựa vào mã Hex truyền vào
        try {
            holder.dotColor.backgroundTintList = ColorStateList.valueOf(Color.parseColor(item.colorHex))
        } catch (e: Exception) {
            holder.dotColor.backgroundTintList = ColorStateList.valueOf(Color.GRAY)
        }
    }

    override fun getItemCount(): Int = favoriteList.size
}