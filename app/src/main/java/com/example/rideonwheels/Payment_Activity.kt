package com.example.rideonwheels

import android.content.Intent
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.rideonwheels.databinding.DesignBookingActivityBinding
import com.example.rideonwheels.databinding.DesignPaymentActivityBinding

class Payment_Activity : AppCompatActivity() {
    private lateinit var brand: TextView
    private lateinit var sender: Button
    private lateinit var imageView: ImageView
    private lateinit var specs: TextView
    private lateinit var price: TextView
    private lateinit var tprice: TextView


    private lateinit var binding: DesignPaymentActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignPaymentActivityBinding.inflate(layoutInflater)
        setContentView(R.layout.design_payment_activity)
        setContentView(binding.root)

        brand = findViewById(R.id.tv_payment_brand_name)
        specs = findViewById(R.id.tv_payment_specs)
        price = findViewById(R.id.tv_payment_price)
        sender = findViewById(R.id.btn_check_out)
        tprice = findViewById(R.id.tv_payment_price1)
        imageView = findViewById(R.id.img_payment_brand) // Replace with the actual ID of your ImageView
//      RECEIVE GLOBAL DATA
        val sharedPreferences = getSharedPreferences("MySharedPrefs", Context.MODE_PRIVATE)
        val specsText = sharedPreferences.getString("specs", "")
        val brandText = sharedPreferences.getString("brand", "")
        val priceText = sharedPreferences.getString("price", "")
        val imageResource = sharedPreferences.getInt("image_resource", 0)
        imageView.setImageResource(imageResource)
        // Set the retrieved data to the TextView
        specs.text = specsText
        brand.text = brandText
        price.text = priceText
        tprice.text = priceText

        binding.btnBackToViewdeal.setOnClickListener {
            startActivity(Intent(this, ViewDeal_Activity::class.java))
        }
    }
}