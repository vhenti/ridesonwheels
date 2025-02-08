package com.example.rideonwheels

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rideonwheels.databinding.DesignProfileTermsAgreementActivityBinding

class Profile_TermsAgreementActivity : AppCompatActivity() {
    private lateinit var binding: DesignProfileTermsAgreementActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignProfileTermsAgreementActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBackToProfile2.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}