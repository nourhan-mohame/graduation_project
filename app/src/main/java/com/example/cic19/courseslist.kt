package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class courseslist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courseslist)

        val tv_2=findViewById<TextView>(R.id.tv_2)
        val tv_3=findViewById<TextView>(R.id.tv_3)


        tv_2.setOnClickListener {
            val intent= Intent(this,Parenting::class.java)
            startActivity(intent)
        }

        tv_3.setOnClickListener {
            val intent = Intent(this, breastcourse::class.java)
            startActivity(intent)
        }
    }
}