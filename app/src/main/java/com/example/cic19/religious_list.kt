package com.example.cic19

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class religious_list: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.religious_list)
        val tv_2=findViewById<TextView>(R.id.tv_2)
        tv_2.setOnClickListener {
            val intent= Intent(this,religious_main::class.java)
            startActivity(intent)
        }

    }
}
