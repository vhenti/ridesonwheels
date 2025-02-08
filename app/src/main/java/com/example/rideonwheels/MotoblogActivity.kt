package com.example.rideonwheels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rideonwheels.databinding.DesignLoginActivityBinding
import com.example.rideonwheels.databinding.DesignMotoblogActivityBinding

class MotoblogActivity : AppCompatActivity() {
    private lateinit var binding: DesignMotoblogActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignMotoblogActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
        binding.btnProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}