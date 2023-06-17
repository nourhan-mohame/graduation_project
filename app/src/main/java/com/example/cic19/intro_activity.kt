package com.example.cic19

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_activity)

        val thread = Thread {
            try {
                Thread.sleep(3000)
                startActivity(Intent(this@IntroActivity, RegisterActivity::class.java))
                finish()
            } catch (e: Exception) {
            }
        }
        thread.start()


    }
}