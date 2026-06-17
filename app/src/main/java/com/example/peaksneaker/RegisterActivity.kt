package com.example.peaksneaker

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Ẩn Action Bar mặc định nếu có
        supportActionBar?.hide()
        setContentView(R.layout.activity_register)

        // Nút Back - Quay lại màn hình trước
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Đóng màn hình đăng ký
        }

        // Chữ "Đăng nhập ngay" - Có thể mở trang Login ở đây
        val txtLoginNow = findViewById<TextView>(R.id.txtLoginNow)
        txtLoginNow.setOnClickListener {
            Toast.makeText(this, "Chuyển sang trang Đăng nhập", Toast.LENGTH_SHORT).show()
            // Sau này ní dùng Intent để chuyển sang LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Nút Đăng ký
        val btnRegister = findViewById<TextView>(R.id.btnRegister)
        btnRegister.setOnClickListener {
            Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show()
        }
    }
}