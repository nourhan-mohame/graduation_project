package com.example.cic19

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class vlogs_adpter (val activity: Activity, val vlogs: ArrayList<vlogs>) :
    RecyclerView.Adapter<vlogs_adpter.VH>() {

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val parent: CardView = view.findViewById(R.id.parent)
        val iv: ImageView = view.findViewById(R.id.image)
        val text: TextView = view.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = activity.layoutInflater.inflate(R.layout.vlogs_cardlist, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: vlogs_adpter.VH, position: Int) {
        holder.iv.setImageResource(vlogs[position].pic)
        holder.text.text = vlogs[position].name

        holder.parent.setOnClickListener {
            val videoUrl = vlogs[position].link
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
            activity.startActivity(intent)
        }
    }

    override fun getItemCount() = vlogs.size
}
