package com.example.rideonwheels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.rideonwheels.databinding.DesignHomeActivityBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: DesignHomeActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignHomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearchToBook.setOnClickListener {
            startActivity(Intent(this, Booking_Activity::class.java))
        }
        binding.btnMotoblog.setOnClickListener {
            startActivity(Intent(this,MotoblogActivity::class.java))
        }
        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}