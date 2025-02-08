package com.example.rideonwheels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rideonwheels.databinding.DesignProfileActivityBinding
import com.example.rideonwheels.databinding.DesignProfileHistoryActivityBinding

class Profile_History_Activity : AppCompatActivity() {
    private lateinit var binding: DesignProfileHistoryActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignProfileHistoryActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}