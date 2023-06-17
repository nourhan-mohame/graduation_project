package com.example.cic19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cic19.databinding.ActivityDarHodaBinding
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

class darHodaActivity : AppCompatActivity(), OnDataReadyCallback {
    var eventListener: ValueEventListener? = null
    private lateinit var binding: ActivityDarHodaBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<dataDar>
    private lateinit var hodaAdapter: HodaAdapter
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDarHodaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rvhoda
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                searchList(newText)
                return true
            }
        })
    }

    private fun fetchData() {
        db.collection("Dar Al Hoda").get()
            .addOnSuccessListener { result ->
                val dataList = ArrayList<dataDar>()
                for (document in result) {
                    Log.d("HodaActivity", "${document.id} => ${document.data}")
                    val data = document.toObject(dataDar::class.java)
                    dataList.add(data)
                }
                onDataReady(dataList)
            }
            .addOnFailureListener { exception ->
                Log.d("HodaActivity", "Error getting documents: ", exception)
            }
    }

    override fun onDataReady(dataList: ArrayList<dataDar>) {
        this.dataList = dataList
        hodaAdapter = HodaAdapter(this, dataList)
        recyclerView.adapter = hodaAdapter
    }

    private fun searchList(text: String) {
        val searchList = ArrayList<dataDar>()
        for (data in dataList) {
            if (data.name.lowercase().contains(text.lowercase(Locale.getDefault())) == true) {
                searchList.add(data)
            }
            else if (data.hobby.lowercase().contains(text.lowercase(Locale.getDefault())) == true
            ) {
                searchList.add(data)
            }
            else if (data.age.lowercase().contains(text.lowercase(Locale.getDefault())) == true) {
                searchList.add(data)
            }
            else if (text.lowercase(Locale.getDefault()) == "male" && data.Gender.lowercase() == "male") {
                searchList.add(data)
            }
            else if (text.lowercase(Locale.getDefault()) == "female" && data.Gender.lowercase() == "female") {
                searchList.add(data)
            }
        }
        hodaAdapter.searchDataList(searchList)
    }
}

interface OnDataReadyCallback {
    fun onDataReady(dataList: ArrayList<dataDar>)
}