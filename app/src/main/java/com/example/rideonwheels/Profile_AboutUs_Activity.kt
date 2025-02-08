package com.example.rideonwheels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rideonwheels.databinding.DesignProfileAboutUsActivityBinding
import com.example.rideonwheels.databinding.DesignProfilePrivacyPolicyActivityBinding

class Profile_AboutUs_Activity : AppCompatActivity() {
    private lateinit var binding: DesignProfileAboutUsActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignProfileAboutUsActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToProfile4.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}