package com.example.cic19

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView



class CinemaAdapter (val activity: Activity, val movies:ArrayList<cinema>):
        RecyclerView.Adapter<CinemaAdapter.MVH>() {
        class MVH (view: View): RecyclerView.ViewHolder(view) {
                val cine:CardView=view.findViewById(R.id.cine)
                val imagecin:ImageView=view.findViewById(R.id.imagecin)
                val tvcin:TextView=view.findViewById(R.id.tvcin)



        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MVH {
                val view=activity.layoutInflater.inflate(R.layout.cinema_list_item,parent,false)
                return MVH(view)

        }

        override fun onBindViewHolder(holder: MVH, position: Int) {
                holder.imagecin.setImageResource(movies[position].pic)
                holder.tvcin.text=movies[position].name

                holder.cine.setOnClickListener {
                        val link = "https://www.yidio.com/movies"
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(link)
                        activity.startActivity(intent)
                }
        }

        private fun startActivity(openURL: Intent) {

        }


        override fun getItemCount() = movies.size



}
