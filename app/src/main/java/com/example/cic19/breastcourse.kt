package com.example.cic19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class breastcourse : AppCompatActivity() {

    var programName = arrayOf(
        "Breastfeeding Success Made Easy",
        "Helping you Breastfeed your Baby with Confidence",
        "Breastfeeding Masterclass - From Beginner to Master",
        "Breastfeeding 101",
        "First Forty Days: After Childbirth",
        "Breastfeeding Basics",
        "Belly Babies: Baby, breastfeeding & post birth recovery",
        "Gravida: Do Pregnancy and Postpartum Preparation Like a Pro",
        "How to breastfeed your baby",
        "From Bump to Baby and Beyond: All The Experts in One Place",
        "Milk Maker",
        "Breastfeeding Masterclass - From Beginner to Master"
    )


    var programImages = intArrayOf(
        R.drawable.breast_1,R.drawable.breast_2,R.drawable.breast_3,
        R.drawable.breast_4,R.drawable.breast_5,R.drawable.breast_6,
        R.drawable.breast_7,R.drawable.breast_8,R.drawable.breast_9,
        R.drawable.breast_10,R.drawable.breast_11,R.drawable.breast_12,
        R.drawable.breast_13

    )
    var urls = arrayOf(
        "https://www.udemy.com/course/breastfeeding-success-made-easy/",

        "https://www.udemy.com/course/helping-you-breastfeed-with-confidence/",

        "https://www.udemy.com/course/breastfeeding-masterclass/",

        "https://www.udemy.com/course/breastfeeding-101/",

        "https://www.udemy.com/course/first-forty-days-after-childbirth/",

        "https://www.udemy.com/course/breastfeeding-basics/",

        "https://www.udemy.com/course/life-with-your-baby-baby-care-breastfeeding/",

        "https://www.udemy.com/course/gravidamom/",

        "https://www.udemy.com/course/how-to-breastfeed-your-baby/",

        "https://www.udemy.com/course/frombumptobabyandbeyond/",

        "https://www.udemy.com/course/milk-maker/",

        "https://www.udemy.com/course/breastfeeding-masterclass/?src=sac&kw=breastfeeding"
    )

    var Instractor = arrayOf(
        "Instractor Name:Anita Wingfield",
        "Instractor Name:Samantha Crompton",
        "Instractor Name:Sylvia Otvos",
        "Instractor Name:Elina Barkan",
        "Instractor Name:Neelufer Mulla",
        "Instractor Name:Angela Plunkett",
        "Instractor Name:Hannah Visagie",
        "Instractor Name:Morgan Michalowski",
        "Instractor Name:Sherri Gunn",
        "Instractor Name:Stephanie Marslen",
        "Instractor Name:Nela Duprat",
        "Instractor Name:Sylvia Otvos"

    )
    var Number_of_register= arrayOf(
        "Number_of_register:2268",
        "Number_of_register:4591",
        "Number_of_register:7451",
        "Number_of_register:3027",
        "Number_of_register:4866",
        "Number_of_register:2613",
        "Number_of_register:3259",
        "Number_of_register:4321",
        "Number_of_register:12376",
        "Number_of_register:5634",
        "Number_of_register:6931",
        "Number_of_register:11874",
        "Number_of_register:3806",
        "Number_of_register:7119",
        "Number_of_register:2196"
    )
    var Places_Available= arrayOf(
        "places 1" ,
        "places 5" ,
        "places 3" ,
        "places 6",
        "places 8" ,
        "places 7",
        "places 2",
        "places 1",
        "places 3",
        "places 13",
        "places 15",
        "places 20" ,
        "places 11"


    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breastcourse)
        // Get the handle for ListView
        val lvProgram: ListView = findViewById(R.id.lvProgram)
        // Specify an adapter and pass context along with all the arrays in constructor
        val breastAdpter =
            breastAdpter(this, programName, programImages,urls,Instractor,Number_of_register,Places_Available)
        //ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription, urls);

        // Set the adapter with the ListView
        lvProgram.setAdapter(breastAdpter)
        /* lvProgram.setOnItemClickListener { parent, view, position, id ->
             val openLinksIntent = Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]))
             startActivity(openLinksIntent)
         }*/
    }


}