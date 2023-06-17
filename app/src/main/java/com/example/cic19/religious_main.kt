package com.example.cic19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class religious_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_religions)

        val religious= arrayListOf<religious>()
        religious.add(religious(R.drawable.c81e3625e30320ef,getString(R.string.religious),"19906 "))
        religious.add(religious(R.drawable.alzahar_1_,getString(R.string.religious),"19906 "))
        religious.add(religious(R.drawable.c81e3625e30320ef,getString(R.string.religious),"19906 "))
        religious.add(religious(R.drawable.alzahar_1_,getString(R.string.religious),"19906 "))
        religious.add(religious(R.drawable.c81e3625e30320ef,getString(R.string.religious),"19906 "))
        religious.add(religious(R.drawable.alzahar_1_,getString(R.string.religious),"19906 "))
        religious.add(religious(R.drawable.c81e3625e30320ef,getString(R.string.religious),"19906 "))
        religious.add(religious(R.drawable.alzahar_1_,getString(R.string.religious),"19906 "))
        religious.add(religious(R.drawable.c81e3625e30320ef,getString(R.string.religious),"19906 "))


        val adapter=religious_Adpter(this,religious)
        val rv: RecyclerView =findViewById(R.id.rv)
        rv.adapter=adapter
    }
}