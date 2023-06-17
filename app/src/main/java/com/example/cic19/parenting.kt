package com.example.cic19

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class Parenting : AppCompatActivity() {


    // Next, prepare your data set. Create two string arrays for program name and program description respectively.
    var programName = arrayOf(
        "Neuroscience for parents: How to raise amazing kids\n",
        "How to get your kids to cooperate-even if they don't want to\n",
        "Parenting Skills to Raise Responsible, Mature Children",
        "Montessori, Course One ~ An Introduction to Montessori\n",
        "Mindful Parenting Certification | Happy Positive Children\n",
        "Positive Parenting - Dealing with Power Struggles\n",
        "Parenting Teens with Confidence: Certified Practitioner\n",
        "Advanced Parenting Skills - BEST Parenting Course Ever!\n",
        "Parenting Children Who Have Experienced Trauma and Adversity\n",
        "How to Share Nature with your Child\n",
        "Prudent parenting for single parents\n",
    )


    // Define an integer array to hold the image recourse ids
    var programImages = intArrayOf(
        R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
        R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
        R.drawable.pic7, R.drawable.pic8, R.drawable.pic9,
        R.drawable.pic10, R.drawable.pic11

    )
    var urls = arrayOf(
        "https://www.udemy.com/course/neuroscience-and-parenting/",
        "https://www.udemy.com/course/raising-responsible-children/",
        "https://www.udemy.com/course/the-top-skills-to-get-your-children-to-listen-and-cooperate/",
        "https://www.udemy.com/course/the-top-skills-to-get-your-children-to-listen-and-cooperate/",
        "https://www.udemy.com/course/an-introduction-to-montessori/",
        "https://www.udemy.com/course/mindful_parenting/",
        "https://www.udemy.com/course/no-i-wont-you-cant-make-me/",
        "https://www.udemy.com/course/parentingteens/",
        "https://www.udemy.com/course/advanced-parenting-skills-best-parenting-class/",
        "https://www.udemy.com/course/trauma-informed-parenting/",
        "https://www.udemy.com/course/how-to-share-nature-with-your-child/"
    )

    var Instractor = arrayOf(
        "Instractor Name: Gergory Caremans",
        "Instractor Name: Roger Kay Allen",
        "Instractor Name: Arlette Shohmelian",
        "Instractor Name: Braco Pobric",
        "Instractor Name: Debbie Godfery",
        "Instractor Name: Braco Pobric",
        "Instractor Name: Randy Hyde",
        "Instractor Name: Susie Macklin",
        "Instractor Name: Paul Cline",
        "Instractor Name: Mary Allison",
        "Instractor Name: Gregory Traymer"

    )
    var Number_of_register = arrayOf(
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
        "Number_of_register:6931"


    )
    var Places_Available = arrayOf(
        "places 1",
        "places 5",
        "places 3",
        "places 6",
        "places 8",
        "places 7",
        "places 2",
        "places 1",
        "places 3",
        "places 13",
        "places 15",
        "places 20",
        "places 11"


    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parenting)
        // Get the handle for ListView
        val lvProgram: ListView = findViewById(R.id.lvProgram)
        // Specify an adapter and pass context along with all the arrays in constructor
        val parentingAdpter =
            parentingAdpter(
                this,
                programName,
                programImages,
                urls,
                Instractor,
                Number_of_register,
                Places_Available
            )
        //ProgramAdapter programAdapter = new ProgramAdapter(this, programName, programImages, programDescription, urls);

        // Set the adapter with the ListView
        lvProgram.setAdapter(parentingAdpter)
        lvProgram.setOnItemClickListener { parent, view, position, id ->
            val openLinksIntent = Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]))
            startActivity(openLinksIntent)
        }
    }
}
