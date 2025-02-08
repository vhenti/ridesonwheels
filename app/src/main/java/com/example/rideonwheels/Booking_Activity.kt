package com.example.rideonwheels

import android.content.Intent
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.rideonwheels.databinding.DesignBookingActivityBinding
import com.example.rideonwheels.databinding.DesignLoginActivityBinding
import com.example.rideonwheels.databinding.DesignMotoblogActivityBinding

class Booking_Activity : AppCompatActivity() {
    private lateinit var brand: TextView
    private lateinit var specs: TextView
    private lateinit var price: TextView
    private lateinit var imageView6: ImageView


    private lateinit var binding: DesignBookingActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignBookingActivityBinding.inflate(layoutInflater)
        setContentView(R.layout.design_booking_activity)
        setContentView(binding.root)

        brand = findViewById(R.id.tv_brand1)
        specs = findViewById(R.id.tv_specs1)
        imageView6 = findViewById(R.id.imageView6)
        price = findViewById(R.id.tv_price1)
//      Global values to pass Data to different activities
        val brandText = brand.text.toString()
        val specsText = specs.text.toString()
        val priceText = price.text.toString()
        val imageResource = R.drawable.auto_beat
        val sharedPreferences = getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("specs", specsText)
        editor.putString("brand", brandText)
        editor.putString("price", priceText)
        editor.putInt("image_resource", imageResource)
        editor.apply()

        binding.btnBackToHome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
        binding.btnBook1.setOnClickListener {
            startActivity(Intent(this, ViewDeal_Activity::class.java))
        }
        binding.btnBook2.setOnClickListener {
            startActivity(Intent(this, ViewDeal_Activity::class.java))
        }
        binding.btnBook3.setOnClickListener {
            startActivity(Intent(this, ViewDeal_Activity::class.java))
        }
        binding.btnBook4.setOnClickListener {
            startActivity(Intent(this, ViewDeal_Activity::class.java))
        }
    }
}