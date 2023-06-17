package com.example.cic19

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AwladyAdapter (private val context: Context, private var dataList: ArrayList<dataDar>) : RecyclerView.Adapter<AwladyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.hoda_list_item, parent, false)
        /* val imageUrl = "https://example.com/image.jpg"*/
        return MyViewHolder(view)
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.nachild)
        var hobby: TextView = itemView.findViewById(R.id.hopchild)
        var age: TextView = itemView.findViewById(R.id.agechild)
        var Gender: TextView = itemView.findViewById(R.id.genchild)
        var image: ImageView = itemView.findViewById(R.id.imagechild)
        var imageUrl: String? = null

        init {
            if (imageUrl != null) {
                Glide.with(itemView.context).load(imageUrl).into(image)

            }
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, foster_opition::class.java)
                itemView.context.startActivity(intent)

            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val childData = dataList[position]
        holder.name.text = childData.name
        holder.hobby.text = childData.hobby
        holder.age.text = childData.age
        holder.Gender.text = childData.Gender
        holder.imageUrl = childData.imageUrl
        Glide.with(context).load(childData.imageUrl).into(holder.image)
    }


    override fun getItemCount(): Int {
        return dataList.size
    }
    fun searchDataList(searchList: ArrayList<dataDar>) {
        dataList = searchList
        notifyDataSetChanged()
    }


}

