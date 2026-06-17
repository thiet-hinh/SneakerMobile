package com.example.peaksneaker

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class SearchResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        // 1. Nút Back (Quay lại trang trước)
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Đóng Activity này, trở về màn hình cũ
        }

        // 2. Setup danh sách sản phẩm tìm kiếm được
        val rvSearchResults = findViewById<RecyclerView>(R.id.rvSearchResults)

        // Tạo dữ liệu giả lập giống hệt hình ảnh
        val searchResults = listOf(
            SearchProduct(1, "Air Jordan 1 Retro...", "Jordan", "$16,000", android.R.drawable.ic_menu_report_image),
            SearchProduct(2, "Air Jordan 4 Retro...", "Jordan", "$19,000", android.R.drawable.ic_menu_report_image),
            SearchProduct(3, "Air Jordan 1 Retro...", "Jordan", "$30,000", android.R.drawable.ic_menu_report_image),
            SearchProduct(4, "Air Jordan 4 Retro...", "Jordan", "$20,000", android.R.drawable.ic_menu_report_image),
            SearchProduct(5, "Air Jordan 4 Retro...", "Jordan", "$18,500", android.R.drawable.ic_menu_report_image),
            SearchProduct(6, "Air Jordan 4 Retro...", "Jordan", "$21,000", android.R.drawable.ic_menu_report_image)
        )

        // Dùng GridLayoutManager với 2 cột
        rvSearchResults.layoutManager = GridLayoutManager(this, 2)
        rvSearchResults.adapter = SearchResultAdapter(searchResults)

        // 3. (Tùy chọn) Highlight tab Shop ở Bottom Navigation cho giống hình
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.selectedItemId = R.id.nav_shop
    }
}