package com.example.rideonwheels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.rideonwheels.databinding.DesignLoginActivityBinding
import com.example.rideonwheels.databinding.DesignRegisterActivityBinding

class Login_Activity : AppCompatActivity() {
    private lateinit var binding: DesignLoginActivityBinding
    private lateinit var db: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignLoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= DatabaseHelper(this)

        binding.tvLoginSignUp.setOnClickListener {
            startActivity(Intent(this,Register_Activity::class.java))
        }

        binding.btLoginLogin.setOnClickListener {
            loginUser()
        }

    }

    private fun loginUser() {
        val email = binding.etLoginNumberOrEmail.text.toString().trim()
        val password = binding.etLoginPassword.text.toString().trim()

        if (ValidationUtils.isTextNotEmpty(email) && ValidationUtils.isTextNotEmpty(password)) {
            if (ValidationUtils.isValidEmail(email)) {
                val isSuccess = db.loginUser(email, password)
                if (isSuccess) {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            } else {
                Toast.makeText(this,"Invalid format email", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this,"Please enter all field", Toast.LENGTH_SHORT).show()
        }
    }
}