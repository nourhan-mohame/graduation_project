package com.example.cic19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class Psychiatrist : AppCompatActivity() {

    var lvProgram: ListView? = null


    var doctor_name = arrayOf(
        "Daniel Azevedo Cavalcante",
        "Jean G. De Oliveira",
        "Marcelo Oliveira Da Costa",
        "Jose Salim Cury",
        "Luiz Antônio De Araújo",
        "Breno Barbosa",
        "Ricardo Coelho",
        "Roberto Rossi Neto",
        "Julieta Gonçalves Silva",
        "Everson De Oliveira Giriboni"
    )

    var programImages = intArrayOf(
        R.drawable.pc_1_33, R.drawable.pc_2_33, R.drawable.pc_3_33,
        R.drawable.pc_4_33, R.drawable.pc_5_33, R.drawable.pc_6_33,
        R.drawable.pc_7_33, R.drawable.pc_8_33, R.drawable.pc_9_33,
        R.drawable.pc_10_33
    )

    var Speciality = arrayOf(
        "Infectious Disease Specialist",
        "Dermatologist",
        "Nutritionist",
        "Optometrist",
        "Sports Medicine Specialist",
        "Urgent Care Specialist",
        "Allergist",
        "Allergist",
        "Optometrist",
        "Urgent Care ",
        "Specialist"
    )
    var Price = arrayOf(
        "Price:320",
        "price:600",
        "price:600",
        "price:600",
        "price:600",
        "price:550",
        "price:320",
        "price:320",
        "price:600",
        "price:600"
    )
    var address = arrayOf(
        "address:39 Pershing Dr",
        "address:2178 Eastern Valley Rd",
        "address:1066 W Grant Rd",
        "address:3140 E Chandler Heights Rd",
        "address:300 Arneill Rd",
        "address:4139 Campus Dr",
        "address:13591 Huron St",
        "address:364 E Main St",
        "address:1820 Gadsden Hwy",
        "address:2109 6th Ave S"
    )
    var Phone = arrayOf(
        "phone:(205) 633-2822",
        "phone:(970) 222-5701",
        "phone:(623) 780-4568",
        "phone:(818) 778-6461",
        "phone:(602) 457-4600",
        "phone:(520) 399-6715",
        "phone:(209) 599-4141",
        "phone:(203) 869-7454",
        "phone:(951) 723-8123",
        "phone:(951) 698-9880"

    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_psychiatrist)

        lvProgram = findViewById(R.id.lvProgram)
        // Specify an adapter and pass context along with all the arrays in constructor
        val psychiatristAdpter =
            psychiatrist_adpter(
                this,
                programImages,
                doctor_name,
                Speciality,
                Price,
                address,
                Phone

            )
        //ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription, urls);

        // Set the adapter with the ListView
        lvProgram?.setAdapter(psychiatristAdpter)
    }

}