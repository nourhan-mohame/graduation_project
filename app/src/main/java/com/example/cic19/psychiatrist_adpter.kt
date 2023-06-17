package com.example.cic19

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Toast

class psychiatrist_adpter (
    con: Context,
    images: IntArray,
    doctor_name: Array<String>,
    Speciality: Array<String>,
    Price: Array<String>,
    address: Array<String>,
    Phone:Array<String>
) : ArrayAdapter<String?>(con, R.layout.activity_psychiatrist, R.id.textView1, doctor_name) {

    private val mContext = con
    private val mImages = images
    private val mDoctorNames = doctor_name
    private val mSpecialities = Speciality
    private val mPrices = Price
    private val mAddresses = address
    private val mPhones = Phone

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var singleItem = convertView
        val viewHolder: psychiatrist_viewholder

        if (singleItem == null) {
            val inflater = LayoutInflater.from(mContext)
            singleItem = inflater.inflate(R.layout.single_item_medical, parent, false)
            viewHolder = psychiatrist_viewholder(singleItem)
            singleItem.tag = viewHolder
        } else {
            viewHolder = singleItem.tag as psychiatrist_viewholder
        }

        viewHolder.itemImage.setImageResource(mImages[position])
        viewHolder.doctor_name.text = mDoctorNames[position]
        viewHolder.Speciality.text = mSpecialities[position]
        viewHolder.Price.text = mPrices[position]
        viewHolder.address.text = mAddresses[position]
        viewHolder.Phone.text = mPhones[position]

        viewHolder.sendbtt.setOnClickListener {
            val intent = Intent(mContext, chat_main::class.java)
            mContext.startActivity(intent)
        }

        return singleItem!!
    }
}