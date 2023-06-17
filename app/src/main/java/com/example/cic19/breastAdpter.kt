package com.example.cic19

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class breastAdpter : ArrayAdapter<String?> {
    var con: Context
    var images: IntArray
    var programName: Array<String>
    var urls: Array<String>
    lateinit var Instractors:Array<String>
    lateinit var Number_of_register:Array<String>
    lateinit var Places_Available:Array<String>

    constructor(
        con: Context,
        programName: Array<String>,
        images: IntArray,
        urls: Array<String>,
        Instractors: Array<String>,
        Number_of_register: Array<String>,
        Places_Available: Array<String>,

    ) : super(con, R.layout.single_item, R.id.textView1, programName) {
        this.con = context
        this.images = images
        this.programName = programName
        this.urls = urls
        this.Instractors=Instractors
        this.Number_of_register=Number_of_register
        this.Places_Available=Places_Available

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // The parameter convertView is null when your app is creating a new item for the first time. It's not null when
        // recycling.
        // Assign the convertView in a View object
        var singleItem = convertView
        // Find a View from the entire View hierarchy by calling findViewById() is a fairly expensive task.
        // So, you'll create a separate class to reduce the number of calls to it.
        // First, create a reference of ProgramViewHolder and assign it to null.
        var holder: breast_viewholder? = null
        // Since layout inflation is a very expensive task, you'll inflate only when creating a new item in the ListView. The first
        // time you're creating a new item, convertView will be null. So, the idea is when creating an item for the first time,
        // we should perform the inflation and initialize the ViewHolder.
        if (singleItem == null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            singleItem = layoutInflater.inflate(R.layout.single_item, parent, false)
            // Pass the singleItem to the constructor of ProgramViewHolder. This singleItem object contains a LinearLayout
            // as the root element for single_item.xml file that contains other Views as well for the ListView.
            holder = breast_viewholder(singleItem)
            // When you create an object of ProgramViewHolder, you're actually calling findViewById() method inside the constructor.
            // By creating ProgramViewHolder only when making new items, you call findViewById() only when making new rows.
            // At this point all the three Views have been initialized. Now you need to store the holder so that you don't need to
            // create it again while recycling and you can do this by calling setTag() method on singleItem and passing the holder as a parameter.
            singleItem.tag = holder
        } else {
            // Get the stored holder object
            holder = singleItem.tag as breast_viewholder
        }
        // Set the values for your views in your item by accessing them through the holder
        holder.itemImage.setImageResource(images[position])
        holder!!.programTitle.text = programName[position]
        holder.Instractor.text=Instractors[position]
        holder.Number_of_register.text= Number_of_register[position].toString()
        holder.Places_Available.text=Places_Available[position].toString()
        singleItem!!.setOnClickListener { //Toast.makeText(getContext(), "You clicked:"+ programName[position], Toast.LENGTH_SHORT).show();
            val openLinksIntent = Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]))
            context.startActivity(openLinksIntent)
        }
        return singleItem
    }
}