package com.example.cic19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cic19.databinding.ActivityAwladyBinding
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*
import kotlin.collections.ArrayList

class AwladyActivity : AppCompatActivity(), OnDataReadyCallback {
    var eventListener: ValueEventListener? = null
    private lateinit var binding: ActivityAwladyBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<dataDar>
    private lateinit var AwladyAdapter: AwladyAdapter
    private var db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAwladyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView = binding.rvarwlady
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()

        binding.searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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
        db.collection("Dar Awlady").get()
            .addOnSuccessListener { result ->
                val dataList = ArrayList<dataDar>()
                for (document in result) {
                    Log.d("AwladyActivity", "${document.id} => ${document.data}")
                    val data = document.toObject(dataDar::class.java)
                    dataList.add(data)
                }
                onDataReady(dataList)
            }
            .addOnFailureListener { exception ->
                Log.d("AwladyActivity", "Error getting documents: ", exception)
            }
    }

    override fun onDataReady(dataList: ArrayList<dataDar>) {
        this.dataList = dataList
        AwladyAdapter = AwladyAdapter(this, dataList)
        recyclerView.adapter = AwladyAdapter
    }

    private fun searchList(text: String) {
        val searchList = ArrayList<dataDar>()
        for (data in dataList) {
            if (data.name.lowercase().contains(text.lowercase(Locale.getDefault())) == true) {
                searchList.add(data)
            }
            else if (data.hobby.lowercase().contains(text.lowercase(Locale.getDefault())) == true && data.age !in "1 month".."1 year") {
                searchList.add(data)
            }
            else if (data.age.lowercase().contains(text.lowercase(Locale.getDefault())) == true) {
                searchList.add(data)
            }
            else if (data.Gender.lowercase().contains(text.lowercase(Locale.getDefault())) == true) {
                searchList.add(data)
            }
            else if (text.lowercase(Locale.getDefault()) == "male" && data.Gender.lowercase() == "male") {
                searchList.add(data)
            }
            else if (text.lowercase(Locale.getDefault()) == "female" && data.Gender.lowercase() == "female") {
                searchList.add(data)
            }
        }
        AwladyAdapter.searchDataList(searchList)
    }
}

