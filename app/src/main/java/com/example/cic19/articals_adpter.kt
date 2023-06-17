package com.example.cic19

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class articals_adpter : ArrayAdapter<String?> {
    var con: Context
    var images: IntArray
    var articalTitle: Array<String>
    var urls: Array<String>
    lateinit var description:Array<String>
    lateinit var published_time:Array<String>
    lateinit var artical_source:Array<String>

    constructor(
        con: Context,
        programName: Array<String>,
        images: IntArray,
        urls: Array<String>,
        description: Array<String>,
        published_time: Array<String>,
        artical_source: Array<String>
    ) : super(con, R.layout.articals_card, R.id.text, programName) {
        this.con = context
        this.images = images
        this.articalTitle = programName
        this.urls = urls
        this.description=description
        this.published_time=published_time
        this.artical_source=artical_source

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // The parameter convertView is null when your app is creating a new item for the first time. It's not null when
        // recycling.
        // Assign the convertView in a View object
        var singleItem = convertView
        // Find a View from the entire View hierarchy by calling findViewById() is a fairly expensive task.
        // So, you'll create a separate class to reduce the number of calls to it.
        // First, create a reference of ProgramViewHolder and assign it to null.
        var holder: articals_viewholder? = null
        // Since layout inflation is a very expensive task, you'll inflate only when creating a new item in the ListView. The first
        // time you're creating a new item, convertView will be null. So, the idea is when creating an item for the first time,
        // we should perform the inflation and initialize the ViewHolder.
        if (singleItem == null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            singleItem = layoutInflater.inflate(R.layout.articals_card, parent, false)
            // Pass the singleItem to the constructor of ProgramViewHolder. This singleItem object contains a LinearLayout
            // as the root element for single_item.xml file that contains other Views as well for the ListView.
            holder = articals_viewholder(singleItem)
            // When you create an object of ProgramViewHolder, you're actually calling findViewById() method inside the constructor.
            // By creating ProgramViewHolder only when making new items, you call findViewById() only when making new rows.
            // At this point all the three Views have been initialized. Now you need to store the holder so that you don't need to
            // create it again while recycling and you can do this by calling setTag() method on singleItem and passing the holder as a parameter.
            singleItem.tag = holder
        } else {
            // Get the stored holder object
            holder = singleItem.tag as articals_viewholder
        }
        // Set the values for your views in your item by accessing them through the holder
        holder.itemImage.setImageResource(images[position])
        holder!!.articalTitle.text = articalTitle[position]
        holder.description.text=description[position]
        holder.artical_source.text= artical_source[position].toString()
        holder.published_time.text=published_time[position].toString()
        /* singleItem!!.setOnClickListener { //Toast.makeText(getContext(), "You clicked:"+ programName[position], Toast.LENGTH_SHORT).show();
             val openLinksIntent = Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]))
             context.startActivity(openLinksIntent)
         }*/
        return singleItem!!
    }
}