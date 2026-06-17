package com.example.peaksneaker

data class ShopProduct(
    val id: Int,
    val name: String,
    val brand: String,
    val badge: String,       // VD: "HOT", "NEW"
    val badgeColor: String,  // VD: "#FF5E00" cho HOT, "#00FF66" cho NEW
    val price: String,       // VD: "$220"
    val imageResId: Int
)