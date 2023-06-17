package com.example.cic19

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView


class CinemaActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cinemaentertainment)

            val  movies= arrayListOf<cinema>()
            movies.add(cinema(R.drawable.c1,"3x3 Eyes: Legend of the Divine Demon (1995)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c2,"A Journey Through Fairyland (1985)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c3,"A Liar's Autobiography: The Untrue Story of Monty Python's Graham Chapman (2012)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c4,"Achmed Saves America (2014)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c5,"Adventure Planet (2012)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c6,"Als je begrijpt wat ik bedoel (1983)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c7,"American Legends (2001)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c8,"Back to the Jurassic (2015)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c9,"Barbie Fairytopia: Magic of the Rainbow (2007)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c10,"Barbie in a Mermaid Tale (2010)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c11,"Barbie Mariposa and Her Butterfly Fairy Friends (2008)\n","https://www.yidio.com/movies"))
            movies.add(cinema(R.drawable.c12,"Barbie Mariposa and the Fairy Princess (2013)\n","https://www.yidio.com/movies"))


        val adapter=CinemaAdapter(this,movies)
        val rv: RecyclerView =findViewById(R.id.rvcine)
        rv.adapter=adapter

    }



}
