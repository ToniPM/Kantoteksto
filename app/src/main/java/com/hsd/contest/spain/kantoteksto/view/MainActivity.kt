package com.hsd.contest.spain.kantoteksto.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.hsd.contest.spain.kantoteksto.R
import com.hsd.contest.spain.kantoteksto.data.LocalSongDataDAOFactory
import com.hsd.contest.spain.kantoteksto.model.ListeningCard
import com.hsd.contest.spain.kantoteksto.model.SongId


class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var textBox: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        //TODO: failure checks in general (particularly for filesystem interface)
        //TODO: see if the timestamping can be done with something else than Duration (min SDK 26)
        //TODO: rotate the play button the other way

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button) as Button
        textBox = findViewById(R.id.textView) as TextView

        button.setOnClickListener(){textBox.setText("Haroo worudo!")}
        textBox.setOnClickListener(){textBox.setText("Tactical bedshitting engaged")}

        val localDataDAOBuilder = LocalSongDataDAOFactory(filesDir)
        val listeningCardDAO = localDataDAOBuilder.listeningCardDAOLocal
        val lyricsDAO = localDataDAOBuilder.lyricsDAOLocal

        val strm_lc = ListeningCard()
        strm_lc.longTermScore.increment()
        val ind_lc = ListeningCard()
        ind_lc.shortTermScore.increment()
        listeningCardDAO[SongId("Papaoutai","Stromae",null)] = strm_lc
        listeningCardDAO[SongId("Dernière Danse", "Indila", null)] = ind_lc
    }
}