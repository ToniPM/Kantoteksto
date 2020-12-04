package com.hsd.contest.spain.kantoteksto.data

import android.util.Log
import java.io.File

class LocalSongDataDAOFactory(rootStorageDir: File) {

    val listeningCardDAOLocal: ListeningCardDAOLocal
    val lyricsDAOLocal: LyricsDAOLocal
    private val localIndex: LocalIndex

    init{
        val localSongDataDir = File(rootStorageDir,"LocalSongData")
        if ( !localSongDataDir.isDirectory) { localSongDataDir.mkdir() }

        localIndex = LocalIndex(localSongDataDir)

        listeningCardDAOLocal = ListeningCardDAOLocal(localSongDataDir, localIndex)
        lyricsDAOLocal = LyricsDAOLocal(localSongDataDir, localIndex)
    }
}