package com.example.cic19

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class listopition : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listopition)
        val card_1= findViewById<LinearLayout>(R.id.card_1)
        val card_2= findViewById<LinearLayout>(R.id.card_2)
        val card_3= findViewById<LinearLayout>(R.id.card_3)
        val card_4= findViewById<LinearLayout>(R.id.card_4)
        val card_5= findViewById<LinearLayout>(R.id.card_5)
        val card_6= findViewById<LinearLayout>(R.id.card_6)
        val card_7= findViewById<LinearLayout>(R.id.card_7)


        card_1.setOnClickListener {

            val intent = Intent(this, foster_main::class.java)
            startActivity(intent)
        }


        card_2.setOnClickListener {

            val intent = Intent(this, courseslist::class.java)
            startActivity(intent)
        }
        card_3.setOnClickListener {

            val intent = Intent(this, medical_main_list::class.java)
            startActivity(intent)
        }
        card_4.setOnClickListener {

            val intent = Intent(this, lost_main::class.java)
            startActivity(intent)
        }
        card_5.setOnClickListener {

            val intent = Intent(this, motivation_main::class.java)
            startActivity(intent)
        }
        card_6.setOnClickListener {

            val intent = Intent(this, religious_list::class.java)
            startActivity(intent)
        }
        card_7.setOnClickListener {

            val intent = Intent(this, Entertanment::class.java)
            startActivity(intent)
        }




    }
}