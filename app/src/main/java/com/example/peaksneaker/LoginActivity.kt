package com.example.peaksneaker

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide() // Ẩn thanh tiêu đề mặc định
        setContentView(R.layout.activity_login)

        // Sự kiện khi bấm "Đăng nhập"
        val btnLogin = findViewById<LinearLayout>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            Toast.makeText(this, "Đang xử lý đăng nhập...", Toast.LENGTH_SHORT).show()
            // Sau này kiểm tra tài khoản xong, ní dùng Intent để chuyển về MainActivity
        }

        // Sự kiện khi bấm "Đăng ký ngay" -> Mở trang Đăng ký
        val txtRegisterNow = findViewById<TextView>(R.id.txtRegisterNow)
        txtRegisterNow.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Sự kiện khi bấm "Quên mật khẩu?"
        val txtForgotPassword = findViewById<TextView>(R.id.txtForgotPassword)
        txtForgotPassword.setOnClickListener {
            Toast.makeText(this, "Chức năng quên mật khẩu đang phát triển!", Toast.LENGTH_SHORT).show()
        }
    }
}