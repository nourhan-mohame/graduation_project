package com.example.cic19

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class medical_viewholder internal constructor(v: View){
    @JvmField
    var itemImage: ImageView
    @JvmField
    var doctor_name: TextView
    @JvmField
    var Speciality: TextView
    @JvmField
    var Price: TextView
    @JvmField
    var address: TextView
    @JvmField
    var Phone: TextView
    @JvmField
    var sendbtt:ImageButton

    init {
        itemImage  = v.findViewById(R.id.imageView)
        doctor_name = v.findViewById(R.id.textView1)
        Speciality = v.findViewById(R.id.textView3)
        Price = v.findViewById(R.id.textView4)
        address = v.findViewById(R.id.textView5)
        Phone = v.findViewById(R.id.textView6)
        sendbtt=v.findViewById(R.id.send_btt)


    }
}