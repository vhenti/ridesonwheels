package com.example.rideonwheels

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.Toast
import com.example.rideonwheels.databinding.DesignRegisterActivityBinding

class Register_Activity : AppCompatActivity() {
    private lateinit var binding: DesignRegisterActivityBinding
    private lateinit var db: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DesignRegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = DatabaseHelper(this)
        binding.btRegisterCreateAccount.setOnClickListener {
            registerUser()
        }

        binding.tvRegisterLogin.setOnClickListener {
            startActivity(Intent(this,Login_Activity::class.java))
        }
    }

    private fun registerUser()  {
        val firstname = binding.etRegisterFirstname.text.toString()
        val lastname = binding.etRegisterLastName.text.toString()
        val mobile = binding.etRegisterMobileNumber.text.toString().toInt()
        val email = binding.etRegisterEmail.text.toString()
        val password = binding.etRegisterPassword.text.toString()

        if (ValidationUtils.isTextNotEmpty(firstname) &&
            ValidationUtils.isTextNotEmpty(lastname) &&
            ValidationUtils.isTextNotFill(mobile) &&
            ValidationUtils.isTextNotEmpty(email) &&
            ValidationUtils.isTextNotEmpty(password)
            ) {
                if (ValidationUtils.isValidEmail(email)) {
                    val user = User(firstname = firstname, lastname = lastname, mobile = mobile, email = email.trim(), password = password )
                    db.registerUser(user)
                    Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Invalid email format", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(this, "Please input all field", Toast.LENGTH_SHORT).show()
        }
    }

}