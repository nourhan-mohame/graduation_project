package com.example.cic19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class vlogs_main : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vlogs_main)
        val vlogs= arrayListOf<vlogs>()

        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs),"https://youtu.be/SxkR73BflYQ"))
        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs_1),"https://youtu.be/Pd84oOOMeMs"))
        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs_2),"https://youtu.be/cklL4hgTrP4"))
        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs_3),"https://youtu.be/Z0iieO58xnk"))
        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs_4),"https://youtu.be/QhCfvXIB9Ks"))
        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs_5),"https://youtu.be/SxkR73BflYQ"))
        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs_6),"https://youtu.be/dcp1OZvJz1w"))
        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs_7),"https://youtu.be/9PC4sAY1TZI"))
        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs_8),"https://www.youtube.com/watch?v=lOeQUwdAjE0"))
        vlogs.add(vlogs(R.drawable.foster,getString(R.string.vlogs_9),"https://youtu.be/xKF7STc2k-w"))

        val adapter=vlogs_adpter(this,vlogs)
        val rv: RecyclerView =findViewById(R.id.rv)
        rv.adapter=adapter
    }
}