package com.example.cic19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class TripActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.trips)

        val  Trip= arrayListOf<trip>()
        Trip.add(trip(R.drawable.t1, "Temple of Karnak", "7:00Am to 5:00Pm", "all week days"))
        Trip.add(trip(R.drawable.t2, "Pyramids of Giza", "7:00Am to 5:00Pm", "all week days"))
        Trip.add(trip(R.drawable.t3, "Abu Simbel Temple", "7:00Am to 5:00Pm", "all week days"))
        Trip.add(trip(R.drawable.t4, "Luxor Temple", "7:00Am to 5:00Pm", "all week days"))
        Trip.add(trip(R.drawable.t5, "Temple of Philae", "7:00Am to 5:00Pm", "all week days"))
        Trip.add(trip(R.drawable.t6, "Mosque of Muhammad Ali", "7:00Am to 5:00Pm", "all week days"))
        Trip.add(trip(R.drawable.t7, "Bibliotheca Alexandrina", "7:00Am to 5:00Pm", "all week days"))
        Trip.add(trip(R.drawable.t8, "The Heavenly Cathedral", "7:00Am to 5:00Pm", "all week days"))
        Trip.add(trip(R.drawable.t9, "Tomb of Ramses VI", "7:00Am to 5:00Pm", "all week days"))


        val adapter=TripAdapter(this,Trip)
        val rv: RecyclerView =findViewById(R.id.rvtrip)
        rv.adapter=adapter

    }
}