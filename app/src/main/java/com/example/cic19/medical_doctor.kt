package com.example.cic19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ListView
import medical_adpter

class medical_doctor : AppCompatActivity() {
    var lvProgram: ListView? = null

    var doctor_name = arrayOf(
        "Miucha Rios O.Zucchi",
        "Bruno Cavellucci",
        "Rômulo Luiz DeCastro",
        "Octavio Grecco",
        "Rafael Martins Coelho",
        "Silvana Chedid Grieco",
        "Ricardo Borges DaSilva",
        "Paulo Elísio",
        "Marcelo Italo Risso",
        "Ana Carolina Congio"

    )
    var programImages = intArrayOf(
        R.drawable.doc_1_34, R.drawable.doc_2_33, R.drawable.doc_3_33,
        R.drawable.doc_4_33, R.drawable.doc_5_33, R.drawable.doc_6_33,
        R.drawable.doc_7_33, R.drawable.doc_8_33, R.drawable.doc_9_33,
        R.drawable.doc_10_33
    )

    var Speciality = arrayOf(
        "Nutritionist",
        "Dietitian",
        "Nutritionist",
        "Nutritionist",
        "Surgeon",
        "Dermatologist",
        "Nutritionist",
        "Adult Psychiatric & Mental Health Nurse Practitioner\n",
        "Dietitian",
        "Surgeon"
    )

    var Price = arrayOf(
        "Price:600",
        "price:600",
        "price:600",
        "price:600",
        "price:320",
        "price:600",
        "price:600",
        "price:600",
        "price:600",
        "price:600"

    )
    var address = arrayOf(
        "address:4383 Clayton Rd",
        "address:1835 S Greenfield Rd",
        "address:924 E Ontario Ave",
        "address:Naval Exchange Building 2017",
        "address:1298 Blue Hills Ave",
        "address:1633 S Higley Rd",
        "address:13300 Washington Blvd",
        "address:1114 1st St N",
        "address:1958 E Brown Rd",
        "address:465 Cottage Grove Rd"
    )

    var Phone = arrayOf(
        "phone:(562)-693-5281",
        "phone:(720)-459-7728",
        "phone:(562)-494-5105",
        "phone:(562)-420-2288",
        "phone:(205)-425-1333",
        "phone:(818)-991-5555",
        "phone:(562)-281-9014",
        "phone:(970)-964-3306",
        "phone:(720)-450-6281",
        "phone:(205)-349-3400"

    )










    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical_doctor)

        lvProgram = findViewById(R.id.lvProgram)
        // Specify an adapter and pass context along with all the arrays in constructor
        val medicalAdpter =
            medical_adpter(
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
        lvProgram?.setAdapter(medicalAdpter)


    }
}

