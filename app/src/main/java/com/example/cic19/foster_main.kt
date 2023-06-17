package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class foster_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foster_main)
        val buttonhoda = findViewById<Button>(R.id.dar1btn)
        val buttonawlady = findViewById<Button>(R.id.dar2btn)


        buttonhoda.setOnClickListener {
            val intent = Intent(this, darHodaActivity::class.java)
            startActivity(intent)
        }

        buttonawlady.setOnClickListener {
            val intent = Intent(this, AwladyActivity::class.java)
            startActivity(intent)
        }


    }
   }