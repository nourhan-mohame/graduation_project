package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class medical_main_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical_main_list)
        val tv_2= findViewById<TextView>(R.id.tv_2)
        val tv_3= findViewById<TextView>(R.id.tv_3)


        tv_2.setOnClickListener {

            val intent = Intent(this, medical_doctor::class.java)
            startActivity(intent)
        }
        tv_3.setOnClickListener {

            val intent = Intent(this, Psychiatrist::class.java)
            startActivity(intent)
        }

    }
}