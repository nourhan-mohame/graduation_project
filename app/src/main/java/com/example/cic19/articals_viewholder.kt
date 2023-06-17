package com.example.cic19

import android.view.View
import android.widget.ImageView
import android.widget.TextView

class articals_viewholder constructor(v: View) {
    // Declare the object references for our views
    @JvmField
    var itemImage: ImageView
    @JvmField
    var articalTitle: TextView
    @JvmField
    var description: TextView

    @JvmField
    var published_time: TextView
    @JvmField
    var artical_source: TextView
    // Get the handles by calling findViewById() on View object inside the constructor
    init {
        itemImage = v.findViewById(R.id.ivArticleImage)
        articalTitle = v.findViewById(R.id.tvTitle)
        description = v.findViewById(R.id.tvDescription)
        published_time = v.findViewById(R.id.tvPublishedAt)
        artical_source = v.findViewById(R.id.tvSource)


    }
}