package com.example.cic19

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MuseumAdapter (val activity: Activity, val Museum:ArrayList<museum>):
        RecyclerView.Adapter<MuseumAdapter.MVH>(){
    class MVH (view: View): RecyclerView.ViewHolder(view) {
        val muse: CardView = view.findViewById(R.id.museum)
        val imagemuse: ImageView = view.findViewById(R.id.imagemuse)
        val namuse: TextView = view.findViewById(R.id.namuse)
        val frommuse: TextView = view.findViewById(R.id.frommuse)
        val daymuse: TextView = view.findViewById(R.id.daymuse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MVH {
        val view=activity.layoutInflater.inflate(R.layout.museum_list_item,parent,false)
        return MVH(view)
    }

    override fun onBindViewHolder(holder: MVH, position: Int) {
        holder.imagemuse.setImageResource(Museum[position].pic)
        holder.namuse.text=Museum[position].name
        holder.frommuse.text=Museum[position].time
        holder.daymuse.text=Museum[position].dayOfWeek
    }

    override fun getItemCount() = Museum.size
    }



