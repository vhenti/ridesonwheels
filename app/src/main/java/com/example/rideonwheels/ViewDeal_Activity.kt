package com.example.rideonwheels

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.rideonwheels.databinding.DesignBookingActivityBinding
import com.example.rideonwheels.databinding.DesignMotoblogActivityBinding
import com.example.rideonwheels.databinding.DesignViewDealActivityBinding

class ViewDeal_Activity : AppCompatActivity() {
    private lateinit var binding: DesignViewDealActivityBinding
    private lateinit var brand: TextView
    private lateinit var price: TextView
    private lateinit var imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignViewDealActivityBinding.inflate(layoutInflater)
        setContentView(R.layout.design_view_deal_activity)
        setContentView(binding.root)

        brand = findViewById(R.id.tv_brand)
        price = findViewById(R.id.tv_price)
        imageView = findViewById(R.id.img_brand)
//      Receive Global Data
        val sharedPreferences = getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE)
        val brandText = sharedPreferences.getString("brand", "")
        val priceText = sharedPreferences.getString("price", "")
        val imageResource = sharedPreferences.getInt("image_resource", 0)
        imageView.setImageResource(imageResource)
        brand.text = brandText
        price.text = priceText


        binding.btnBackToBooking.setOnClickListener {
            startActivity(Intent(this, Booking_Activity::class.java))
        }
        binding.btnViewDeal.setOnClickListener {
            startActivity(Intent(this, Payment_Activity::class.java))
        }
    }
}