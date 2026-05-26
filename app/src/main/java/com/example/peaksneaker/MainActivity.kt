package com.example.peaksneaker

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ==========================================
        // 1. SETUP TRANG CHỦ (HOME SCREEN)
        // ==========================================
        val rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        val categories = listOf(
            Category(1, "Tất cả", android.R.drawable.ic_menu_compass),
            Category(2, "Nike", android.R.drawable.ic_menu_gallery),
            Category(3, "Adidas", android.R.drawable.ic_menu_gallery),
            Category(4, "Puma", android.R.drawable.ic_menu_gallery)
        )
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = CategoryAdapter(categories)

        val rvProducts = findViewById<RecyclerView>(R.id.rvProducts)
        val products = listOf(
            Product(1, "YEEZY BOOST 350 V2", "Adidas", "HOT", android.R.drawable.ic_menu_report_image),
            Product(2, "AIR JORDAN 1 RETRO", "Nike", "NEW", android.R.drawable.ic_menu_report_image)
        )
        rvProducts.layoutManager = GridLayoutManager(this, 2)
        rvProducts.adapter = ProductAdapter(products)

        // ==========================================
        // 2. SETUP TRANG YÊU THÍCH (FAVORITE SCREEN)
        // ==========================================
        val rvFavorites = findViewById<RecyclerView>(R.id.rvFavorites)
        val txtCountFavorite = findViewById<TextView>(R.id.txtCountFavorite)

        // Tạo danh sách dữ liệu mẫu chuẩn theo thiết kế Figma của ní luôn
        val favoriteProducts = listOf(
            FavoriteProduct(1, "YEEZY BOOST 350 V2 'MONO ICE'", "Nike", "$220", "9", "Mono Ice", "#E5CCB4", android.R.drawable.ic_menu_report_image),
            FavoriteProduct(2, "AIR JORDAN 1 RETRO 'HYPE ROYAL'", "Nike", "$180", "10", "Black/Orange", "#2B2B2B", android.R.drawable.ic_menu_report_image),
            FavoriteProduct(3, "SB DUNK LOW 'PANDORA'", "Nike", "$160", "9", "Pandora", "#7A1E1E", android.R.drawable.ic_menu_report_image),
            FavoriteProduct(4, "AIR JORDAN 4 RETRO 'CEMENT'", "Nike", "$210", "10", "Black/Orange", "#CCCCCC", android.R.drawable.ic_menu_report_image)
        )

        // Cập nhật số lượng sản phẩm hiển thị trên text
        txtCountFavorite?.text = "(${favoriteProducts.size} sản phẩm)"

        // Đổ dữ liệu vào RecyclerView yêu thích
        rvFavorites?.layoutManager = LinearLayoutManager(this)
        rvFavorites?.adapter = FavoriteAdapter(favoriteProducts)

        // ==========================================
        // 3. LOGIC CHUYỂN ĐỔI ẨN / HIỆN MÀN HÌNH (ĐÃ SỬA ID KHỚP VỚI XML)
        // ==========================================

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val layoutHome = findViewById<View>(R.id.layoutHome)
        val layoutFavorite = findViewById<View>(R.id.layoutFavorite)

        // Thiết lập ban đầu khi vừa vào app: Hiện trang chủ, ẩn trang yêu thích
        layoutHome.visibility = View.VISIBLE
        layoutFavorite.visibility = View.GONE

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    layoutHome.visibility = View.VISIBLE
                    layoutFavorite.visibility = View.GONE
                    true
                }
                R.id.nav_wishlist -> {
                    layoutHome.visibility = View.GONE
                    layoutFavorite.visibility = View.VISIBLE
                    true
                }
                R.id.nav_shop, R.id.nav_profile -> {
                    // Nếu bấm vào các tab chưa code, ẩn tạm 2 layout chính đi để tránh bị đè giao diện
                    layoutHome.visibility = View.GONE
                    layoutFavorite.visibility = View.GONE
                    true
                }
                else -> false
            }
        }
    }
}