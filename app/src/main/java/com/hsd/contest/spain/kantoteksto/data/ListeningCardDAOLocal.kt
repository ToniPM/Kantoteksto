package com.hsd.contest.spain.kantoteksto.data

import com.hsd.contest.spain.kantoteksto.model.ListeningCard
import com.hsd.contest.spain.kantoteksto.model.SongId
import java.io.*

class ListeningCardDAOLocal(storageDir: File,
                            val index: LocalIndex): ListeningCardDAO {

    private val archiveDir: File = File(storageDir, "ListeningCards")

    init{
        if(!archiveDir.isDirectory){ archiveDir.mkdir() }
    }

    override operator fun get(songId: SongId): ListeningCard {
        val numericalId = index.getIndex(songId)
        val file = File(archiveDir, "$numericalId")
        if (file.isFile) {
            return ListeningCard(file)
        } else {
            TODO("return some emptylisteningcard")
        }
    }

    override operator fun set(songId: SongId, listeningCard : ListeningCard){
        val newNumericalId = index.getIndex(songId)

        val newFile = File(archiveDir, "$newNumericalId")
        newFile.createNewFile()
        listeningCard.writeTo(newFile)
    }
}