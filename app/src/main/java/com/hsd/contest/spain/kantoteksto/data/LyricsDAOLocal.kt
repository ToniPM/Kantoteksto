package com.hsd.contest.spain.kantoteksto.data

import com.hsd.contest.spain.kantoteksto.model.Lyrics
import com.hsd.contest.spain.kantoteksto.model.SongId
import java.io.File

class LyricsDAOLocal (storageDir: File,
                      val index: LocalIndex): LyricsDAO {

    private val archiveDir: File = File(storageDir, "Lyrics")

    init{
        if(!archiveDir.isDirectory){ archiveDir.mkdir() }
    }

    override operator fun get(songId: SongId): Lyrics {
        val numericalId = index.getIndex(songId)
        val file = File(archiveDir, "$numericalId")
        if (file.exists()) {
            return Lyrics(file)
        } else {
            TODO("return some emptylyrics")
        }
    }

    override operator fun set(songId: SongId, lyrics: Lyrics){
        val newNumericalId = index.getIndex(songId)

        val newFile = File(archiveDir, "$newNumericalId")
        newFile.createNewFile()
        lyrics.writeTo(newFile)
    }
}