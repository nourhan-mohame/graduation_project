package com.example.cic19

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class articals_main : AppCompatActivity() {



    // Next, prepare your data set. Create two string arrays for program name and program description respectively.
    var articaltitle = arrayOf(
        "Mirna and Mohammed's journey with their son,Suleiman.",
        "Do I love him as if he were my son whom I gave birth?",
        "Idaho Mom Celebrates First Mother's Day After Adopting Four Foster Siblings",
        " A Mother's Journey to Regain Custody of Her Children",
        "Adoption celebrates 700th anniversary.",
        "Foster mothers are empowering children to have a family.",


        )


    // Define an integer array to hold the image recourse ids
    var programImages = intArrayOf(
        R.drawable.foster_a_1,R.drawable.fostercare_2,R.drawable.fostercare_3
        ,R.drawable.foster_4,R.drawable.foster_5,R.drawable.foster_6

    )
    var urls = arrayOf(
        "https://www.almasryalyoum.com/news/details/2618477",
        "https://www.shorouknews.com/news/view.aspx?cdate=07072021&id=c87a1306-98f7-45da-a38d-9bd2d68ff273",
        "https://kafala.net/blog/33",
        "https://www.10tv.com/article/news/nation-world/idaho-woman-celebrates-her-first-mothers-day-after-adopting-four-children-2020-may/530-8832333e-0f63-4c3b-b2ec-5630530a4189",
        "https://www.thv11.com/article/news/local/outreach/a-place-to-call-home/she-was-a-mom-on-a-mission-mother-overcomes-addiction-works-with-foster-parents-to-get-her-kids-back/91-98d073d3-f70e-40f0-86dd-56133f596717",
        "https://www.cbsnews.com/news/2-year-old-in-foster-care-for-700-days-gets-virtual-adoption-hearing-and-parade-to-celebrate/?ftag=CNM-00-10aab7e&linkId=88745206",


        )

    var description = arrayOf(
        "Mirna and Mohammed's story of embracing and sponsoring a child and raising him with their small child is a true story.",
        "The stages of the journey",
        "I was allowed to become a mother, but now I have big concerns about my child's safety.",
        "Adoption can bring joy and fulfillment to families, and is a reminder of the power of love and determination in creating a loving home.",
        "The story of a mother who overcame addiction and worked with foster parents to regain custody of her children highlights the power of determination, support, and love in overcoming adversity. It also emphasizes the importance of family in helping individuals achieve their goals.",
        "The story of a 2-year-old boy who spent 700 days in foster care before being adopted by his forever family is a testament to the resilience of children in the foster care system and the positive impact that foster and adoptive families can have in their lives.",


        )
    var published_time= arrayOf(
        "PUBLISHED:July10,2022",
        "PUBLISHED:July25,2022",
        "PUBLISHED:May11,2020",
        "PUBLISHED:May26,2019",
        "PUBLISHED:May15,2019",
        "PUBLISHED:July7,2021",



        )
    var artical_source= arrayOf(
        "AL-Shorouk newspaper",
        "kafala",
        "almasryalyoum",
        "Nation World",
        "A PLACE TO CALL HOME",
        "OCBS NEWS"





    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_articals_main)
        // Get the handle for ListView
        val lvProgram: ListView = findViewById(R.id.lvprogram)
        // Specify an adapter and pass context along with all the arrays in constructor
        val parentingAdpter =
            articals_adpter(
                this,
                articaltitle,
                programImages,
                urls,
                description,
                published_time,
                artical_source
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
