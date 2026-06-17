package com.example.peaksneaker

data class Order(
    val id: Int,
    val name: String,
    val codeAndSize: String,
    val status: String,
    val price: String,
    val imageResId: Int,
    val statusBgColor: String,
    val statusTextColor: String
)