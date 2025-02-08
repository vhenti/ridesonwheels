package com.example.rideonwheels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rideonwheels.databinding.DesignBookingActivityBinding
import com.example.rideonwheels.databinding.DesignProfilePrivacyPolicyActivityBinding

class Profile_PrivacyPolicy_Activity : AppCompatActivity() {
    private lateinit var binding: DesignProfilePrivacyPolicyActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignProfilePrivacyPolicyActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToProfile3.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}