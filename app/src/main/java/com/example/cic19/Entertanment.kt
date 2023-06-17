package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Entertanment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entertanment)

        val buttonCinema = findViewById<Button>(R.id.cinemabtn)
        val buttonTrip = findViewById<Button>(R.id.tripbtn)
        val buttonMuseum = findViewById<Button>(R.id.museumbtn)

        buttonCinema.setOnClickListener {
            val intent = Intent(this, CinemaActivity::class.java)
            startActivity(intent)
        }

        buttonTrip.setOnClickListener {
            val intent = Intent(this, TripActivity::class.java)
            startActivity(intent)
        }

        buttonMuseum.setOnClickListener {
            val intent = Intent(this, museumActivity::class.java)
            startActivity(intent)
        }
    }
}