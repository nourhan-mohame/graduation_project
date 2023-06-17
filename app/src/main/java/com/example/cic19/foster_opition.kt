package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class foster_opition : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foster_opition)

        val decoument = findViewById<TextView>(R.id.decoument)
        val foster_payment = findViewById<TextView>(R.id.foster_payment)



        decoument.setOnClickListener {
            val intent = Intent(this,main_decoument ::class.java)
            startActivity(intent)
        }


        foster_payment.setOnClickListener {
            val intent = Intent(this,payment ::class.java)
            startActivity(intent)
        }


    }
}