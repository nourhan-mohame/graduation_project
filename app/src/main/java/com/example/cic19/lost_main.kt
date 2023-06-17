package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class lost_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lost_main)
        val thread = Thread {
            try {
                Thread.sleep(5000)
                startActivity(Intent(this@lost_main, LostChildren::class.java))
                finish()
            } catch (e: Exception) {
            }
        }
        thread.start()
    }
}