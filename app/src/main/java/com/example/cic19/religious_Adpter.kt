package com.example.cic19

import android.app.Activity
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

class religious_Adpter (val activity: Activity, val religious:ArrayList<religious>):
    RecyclerView.Adapter<religious_Adpter.VH>(){
    class VH(view: View): RecyclerView.ViewHolder(view){
        val parent: CardView =view.findViewById(R.id.parent)
        val iv: ImageView =view.findViewById(R.id.image)
        val text: TextView =view.findViewById(R.id.text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val view=activity.layoutInflater.inflate(R.layout.religions_cardlist,parent,false)
        return VH(view)
    }

    override fun onBindViewHolder(holder:religious_Adpter.VH, position: Int) {

        holder.iv.setImageResource(religious[position].pic)
        holder.text.text=religious[position].name

        holder.parent.setOnClickListener {
            val i= Intent(Intent.ACTION_DIAL,"tel:${religious[position].number} ".toUri())
            activity.startActivity(i)
        }
    }

    override fun getItemCount()=religious.size


}