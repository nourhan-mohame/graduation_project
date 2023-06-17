package com.example.cic19

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class museumActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.museumentertainment)

        val  Museum= arrayListOf<museum>()
        Museum.add(museum(R.drawable.m1,"National Military Museum","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m2,"the National Museum of Suez","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m3,"Helwan Corner Museum","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m4,"Crocodile Museum","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m5,"National Police Museum","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m6,"Cairo International Airport Museum - Terminal 2","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m7,"The Egyptian Museum","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m8,"Museum of Islamic Art","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m9,"The Coptic Museum","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m10,"National Museum of Egyptian Civilization(NMEC)","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m11,"Egypt’s Capitals Museum ( ECM )","8:00Am to 4:00Pm","all week days"))
        Museum.add(museum(R.drawable.m12,"Cairo International Airport Museum - Terminal 3","8:00Am to 4:00Pm","all week days"))



        val adapter=MuseumAdapter(this,Museum)
        val rv: RecyclerView =findViewById(R.id.rvmuseum)
        rv.adapter=adapter

    }
}