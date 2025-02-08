package com.example.rideonwheels

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.rideonwheels.databinding.DesignBookingActivityBinding
import com.example.rideonwheels.databinding.DesignProfileActivityBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: DesignProfileActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignProfileActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gFormTextView: TextView  = findViewById(R.id.tv_term_agreement)

        binding.tvHistory.setOnClickListener {
            startActivity(Intent(this, Profile_History_Activity::class.java))
        }
        binding.tvTermAgreement.setOnClickListener {
            val googleFormUrl = "https://docs.google.com/forms/d/e/1FAIpQLSdGTS79k_y7HF7REZQwHoOTcjFLB24ryGjyeilQhy0bar_jJg/viewform?usp=sf_link"
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(googleFormUrl))

            if(webIntent.resolveActivity(packageManager) != null){
                startActivity(webIntent)
            }else{
                android.widget.Toast.makeText(this, "", Toast.LENGTH_SHORT).show()
            }
        }
        binding.tvPrivacy.setOnClickListener {
            startActivity(Intent(this, Profile_PrivacyPolicy_Activity::class.java))
        }
        binding.tvAbout.setOnClickListener {
            startActivity(Intent(this, Profile_AboutUs_Activity::class.java))
        }
        binding.tvSignOut.setOnClickListener {
            startActivity(Intent(this, Login_Activity::class.java))
        }

        binding.btnSearch.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
        binding.btnMotoblog.setOnClickListener {
            startActivity(Intent(this, MotoblogActivity::class.java))
        }
    }
}