package com.example.cic19

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class TripAdapter (val activity: Activity, val Trip:ArrayList<trip>):
    RecyclerView.Adapter<TripAdapter.MVH>(){
    class MVH (view: View): RecyclerView.ViewHolder(view) {
        val trip: CardView = view.findViewById(R.id.tripcrard)
        val imagetrip: ImageView = view.findViewById(R.id.imagetrip)
        val natrip: TextView = view.findViewById(R.id.natrip)
        val fromtrip: TextView = view.findViewById(R.id.fromtrip)
        val daytrip: TextView = view.findViewById(R.id.daytrip)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MVH {
        val view=activity.layoutInflater.inflate(R.layout.trip_list_item,parent,false)
        return MVH(view)
    }

    override fun onBindViewHolder(holder: MVH, position: Int) {
        holder.imagetrip.setImageResource(Trip[position].pic)
        holder.natrip.text=Trip[position].name
        holder.fromtrip.text=Trip[position].time
        holder.daytrip.text=Trip[position].dayOfWeek
    }


    override fun getItemCount() = Trip.size


}