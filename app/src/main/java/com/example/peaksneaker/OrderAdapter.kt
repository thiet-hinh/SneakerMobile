package com.example.peaksneaker

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class OrderAdapter(private val orderList: List<Order>) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgOrderProduct: ImageView = itemView.findViewById(R.id.imgOrderProduct)
        val txtOrderName: TextView = itemView.findViewById(R.id.txtOrderName)
        val txtOrderCode: TextView = itemView.findViewById(R.id.txtOrderCode)
        val cardOrderStatus: CardView = itemView.findViewById(R.id.cardOrderStatus)
        val txtOrderStatus: TextView = itemView.findViewById(R.id.txtOrderStatus)
        val txtOrderPrice: TextView = itemView.findViewById(R.id.txtOrderPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order_history, parent, false)
        return OrderViewHolder(view)
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orderList[position]
        holder.imgOrderProduct.setImageResource(order.imageResId)
        holder.txtOrderName.text = order.name
        holder.txtOrderCode.text = order.codeAndSize
        holder.txtOrderStatus.text = order.status
        holder.txtOrderPrice.text = order.price

        // Cập nhật màu sắc cho viên thuốc trạng thái (Pill status)
        holder.cardOrderStatus.setCardBackgroundColor(Color.parseColor(order.statusBgColor))
        holder.txtOrderStatus.setTextColor(Color.parseColor(order.statusTextColor))
    }

    override fun getItemCount(): Int = orderList.size
}