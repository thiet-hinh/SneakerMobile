package com.example.peaksneaker

data class FavoriteProduct(
    val id: Int,
    val name: String,
    val brand: String,
    val price: String,
    val size: String,
    val colorName: String,
    val colorHex: String, // Mã màu Hex (Ví dụ: #E5CCB4) để đổi màu dấu chấm tròn
    val imageRes: Int
)