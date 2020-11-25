package com.myhome.rpgkeyboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.myhome.rpgkeyboard.activities.address.Address
import com.myhome.rpgkeyboard.activities.bank.Bank
import com.myhome.rpgkeyboard.activities.email.Email
import com.myhome.rpgkeyboard.activities.password.Password
import com.myhome.rpgkeyboard.activities.remnant.Remnant
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        address_b.setOnClickListener{
            val addressIntent = Intent(this, Address::class.java)
            startActivity(addressIntent)
        }
        bank_b.setOnClickListener{
            val bankIntent = Intent(this, Bank::class.java)
            startActivity(bankIntent)
        }
        email_b.setOnClickListener{
            val emailIntent = Intent(this, Email::class.java)
            startActivity(emailIntent)
        }
        password_b.setOnClickListener{
            val passwordIntent = Intent(this, Password::class.java)
            startActivity(passwordIntent)
        }
        remnant_b.setOnClickListener{
            val remnantIntent = Intent(this, Remnant::class.java)
            startActivity(remnantIntent)
        }

    }




}
