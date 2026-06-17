package com.example.peaksneaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
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
        val favoriteProducts = listOf(
            FavoriteProduct(1, "YEEZY BOOST 350 V2 'MONO ICE'", "Nike", "$220", "9", "Mono Ice", "#E5CCB4", android.R.drawable.ic_menu_report_image),
            FavoriteProduct(2, "AIR JORDAN 1 RETRO 'HYPE ROYAL'", "Nike", "$180", "10", "Black/Orange", "#2B2B2B", android.R.drawable.ic_menu_report_image),
            FavoriteProduct(3, "SB DUNK LOW 'PANDORA'", "Nike", "$160", "9", "Pandora", "#7A1E1E", android.R.drawable.ic_menu_report_image),
            FavoriteProduct(4, "AIR JORDAN 4 RETRO 'CEMENT'", "Nike", "$210", "10", "Black/Orange", "#CCCCCC", android.R.drawable.ic_menu_report_image)
        )
        txtCountFavorite?.text = "(${favoriteProducts.size} sản phẩm)"
        rvFavorites?.layoutManager = LinearLayoutManager(this)
        rvFavorites?.adapter = FavoriteAdapter(favoriteProducts)

        // ==========================================
        // 3. SETUP TRANG CỬA HÀNG (SHOP SCREEN)
        // ==========================================
        val rvShopCategories = findViewById<RecyclerView>(R.id.rvShopCategories)
        val shopCategories = listOf(
            Category(1, "Tất cả", android.R.drawable.ic_menu_compass),
            Category(2, "Nike", android.R.drawable.ic_menu_gallery),
            Category(3, "Adidas", android.R.drawable.ic_menu_gallery),
            Category(4, "Puma", android.R.drawable.ic_menu_gallery),
            Category(5, "Phụ kiện", android.R.drawable.ic_menu_preferences)
        )
        rvShopCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvShopCategories.adapter = ShopCategoryAdapter(shopCategories)

        // Setup Lưới sản phẩm
        val rvShopProducts = findViewById<RecyclerView>(R.id.rvShopProducts)
        val shopProductsData = listOf(
            ShopProduct(1, "YEEZY BOOST 350 V2", "ADIDAS", "HOT", "#FF5E00", "$220", android.R.drawable.ic_menu_report_image),
            ShopProduct(2, "AIR JORDAN 1 RETRO", "NIKE", "HOT", "#FF5E00", "$180", android.R.drawable.ic_menu_report_image),
            ShopProduct(3, "AIR JORDAN 1 RETRO", "NIKE", "NEW", "#00FF66", "$180", android.R.drawable.ic_menu_report_image),
            ShopProduct(4, "AIR MAX 90 OG", "NIKE", "HOT", "#FF5E00", "$150", android.R.drawable.ic_menu_report_image),
            ShopProduct(5, "NIKE SB DUNK", "NIKE", "NEW", "#00FF66", "$220", android.R.drawable.ic_menu_report_image),
            ShopProduct(6, "NEW BALANCE 990", "NEW BALANCE", "NEW", "#00FF66", "$450", android.R.drawable.ic_menu_report_image)
        )
        rvShopProducts.layoutManager = GridLayoutManager(this, 2)
        rvShopProducts.adapter = ShopProductAdapter(shopProductsData)

        // ==========================================
        // 4. SETUP TRANG HỒ SƠ (PROFILE SCREEN)
        // ==========================================
        val rvOrderHistory = findViewById<RecyclerView>(R.id.rvOrderHistory)

        val orderProducts = listOf(
            Order(1, "YEEZY BOOST 350 V2", "#SV-230520 • Size 9", "✓ Đã giao", "$220", android.R.drawable.ic_menu_report_image, "#152B1E", "#00FF66"),
            Order(2, "AIR JORDAN 1 RETRO", "#SV-230518 • Size 10", "🕒 Đang giao", "$180", android.R.drawable.ic_menu_report_image, "#331919", "#FF5E00"),
            Order(3, "AIR MAX '90 OG", "#SV-230516 • Size 8", "⚙ Đang xử lý", "$150", android.R.drawable.ic_menu_report_image, "#1A2533", "#3388FF")
        )

        rvOrderHistory?.layoutManager = LinearLayoutManager(this)
        rvOrderHistory?.adapter = OrderAdapter(orderProducts)

        // --- BẮT ĐẦU: LOGIC GIAO DIỆN CHƯA ĐĂNG NHẬP / ĐÃ ĐĂNG NHẬP ---
        val layoutGuestState = findViewById<LinearLayout>(R.id.layoutGuestState)
        val layoutLoggedState = findViewById<LinearLayout>(R.id.layoutLoggedState)

        // Biến kiểm tra trạng thái đăng nhập (đổi thành true nếu muốn test xem giao diện User)
        val isUserLoggedIn = false

        if (layoutGuestState != null && layoutLoggedState != null) {
            if (isUserLoggedIn) {
                layoutGuestState.visibility = View.GONE
                layoutLoggedState.visibility = View.VISIBLE
            } else {
                layoutGuestState.visibility = View.VISIBLE
                layoutLoggedState.visibility = View.GONE
            }
        }

        // Bắt sự kiện bấm nút "ĐĂNG NHẬP NGAY" để mở LoginActivity
        val btnGoToLogin = findViewById<Button>(R.id.btnGoToLogin)
        btnGoToLogin?.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Bắt sự kiện bấm nút "TẠO TÀI KHOẢN MỚI" để mở RegisterActivity
        val btnGoToRegister = findViewById<Button>(R.id.btnGoToRegister)
        btnGoToRegister?.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        // --- KẾT THÚC: LOGIC GIAO DIỆN CHƯA ĐĂNG NHẬP / ĐÃ ĐĂNG NHẬP ---


        // ==========================================
        // 5. LOGIC DIỀU HƯỚNG CHUYỂN ĐỔI 4 TABS TOÀN DIỆN
        // ==========================================
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val layoutHome = findViewById<View>(R.id.layoutHome)
        val layoutFavorite = findViewById<View>(R.id.layoutFavorite)
        val layoutShop = findViewById<View>(R.id.layoutShop)
        val layoutProfile = findViewById<View>(R.id.layoutProfile)

        // Trạng thái hiển thị ban đầu khi mở ứng dụng
        layoutHome.visibility = View.VISIBLE
        layoutFavorite.visibility = View.GONE
        layoutShop.visibility = View.GONE
        layoutProfile.visibility = View.GONE

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    layoutHome.visibility = View.VISIBLE
                    layoutFavorite.visibility = View.GONE
                    layoutShop.visibility = View.GONE
                    layoutProfile.visibility = View.GONE
                    true
                }
                R.id.nav_shop -> {
                    layoutHome.visibility = View.GONE
                    layoutFavorite.visibility = View.GONE
                    layoutShop.visibility = View.VISIBLE
                    layoutProfile.visibility = View.GONE
                    true
                }
                R.id.nav_wishlist -> {
                    layoutHome.visibility = View.GONE
                    layoutFavorite.visibility = View.VISIBLE
                    layoutShop.visibility = View.GONE
                    layoutProfile.visibility = View.GONE
                    true
                }
                R.id.nav_profile -> {
                    layoutHome.visibility = View.GONE
                    layoutFavorite.visibility = View.GONE
                    layoutShop.visibility = View.GONE
                    layoutProfile.visibility = View.VISIBLE
                    true
                }
                else -> false
            }
        }
    }
}