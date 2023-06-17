package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class payment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        val myImageButton1 = findViewById<ImageButton>(R.id.btnimage1)
        val myImageButton2 = findViewById<ImageButton>(R.id.btnimage2)
        val myImageButton3 = findViewById<ImageButton>(R.id.btnimage3)


        myImageButton1.setImageResource(R.drawable.paypal)
        myImageButton1.setOnClickListener {
            val intent = Intent(this, textpayment::class.java)
            startActivity(intent)
        }
        myImageButton2.setImageResource(R.drawable.mas)
        myImageButton2.setOnClickListener {
            val intent = Intent(this, textpayment::class.java)
            startActivity(intent)
        }
        myImageButton3.setImageResource(R.drawable.visa)
        myImageButton3.setOnClickListener {
            val intent = Intent(this, textpayment::class.java)
            startActivity(intent)
        }
    }
    }
