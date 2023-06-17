package com.example.cic19

import android.view.View
import android.widget.ImageView
import android.widget.TextView

class parenting_viewholder internal constructor(v: View) {
    // Declare the object references for our views
    @JvmField
    var itemImage: ImageView
    @JvmField
    var programTitle: TextView
    @JvmField
    var Instractor: TextView

    @JvmField
    var Number_of_register: TextView
    @JvmField
    var Places_Available: TextView
    // Get the handles by calling findViewById() on View object inside the constructor
    init {
        itemImage = v.findViewById(R.id.imageView)
        programTitle = v.findViewById(R.id.textView1)
        Instractor = v.findViewById(R.id.textView3)
        Number_of_register = v.findViewById(R.id.textView4)
        Places_Available = v.findViewById(R.id.textView5)


    }
}