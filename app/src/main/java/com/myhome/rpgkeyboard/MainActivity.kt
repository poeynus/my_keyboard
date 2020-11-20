package com.myhome.rpgkeyboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingHeader = findViewById<ConstraintLayout>(R.id.setting_header)
        val submitButton = settingHeader.findViewById<TextView>(R.id.submit_text)
        submitButton.visibility = View.GONE

        bank_btn.setOnClickListener{
            val intent = Intent(this, BankActivity::class.java)
            startActivity(intent)
        }
        address_btn.setOnClickListener{
            val intent = Intent(this, AddressActivity::class.java)
            startActivity(intent)
        }
        email_btn.setOnClickListener{
            val intent = Intent(this, EmailActivity::class.java)
            startActivity(intent)
        }
        password_btn.setOnClickListener{
            val intent = Intent(this, PasswordActivity::class.java)
            startActivity(intent)
        }
        remnant_btn.setOnClickListener{
            val intent = Intent(this, RemnantActivity::class.java)
            startActivity(intent)
        }

    }




}
