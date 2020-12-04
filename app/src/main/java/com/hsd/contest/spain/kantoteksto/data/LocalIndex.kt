package com.hsd.contest.spain.kantoteksto.data

import com.hsd.contest.spain.kantoteksto.model.SongId
import java.io.*

class LocalIndex(val storageDir: File) {
    private val indexFile: File

    private var index: HashMap<SongId, Int>

    init{

        indexFile = File(storageDir, "index")
        if(!indexFile.isFile){
            indexFile.createNewFile()
            index = HashMap<SongId, Int>()

            //TODO("remove this unecessary saving (add proper saving schedules/times)")
            saveChanges()
        } else {
            val ips = FileInputStream(indexFile)
            ObjectInputStream(ips).use{
                index = it.readObject() as HashMap<SongId, Int>
            }
        }
    }

    fun isIndexed(songId: SongId): Boolean {
        return index[songId]!=null
    }

    fun getIndex(songId: SongId): Int {
        val pulledIndex = index[songId]

        return pulledIndex ?: getNewIndex(songId)
    }

    private fun getNewIndex(songId: SongId): Int{
        val newNumericalId = index.size
        index[songId] = newNumericalId
        return newNumericalId
    }

    private fun saveChanges(){
        ObjectOutputStream(FileOutputStream(indexFile)).use{
            it.writeObject(index)
        }
    }
}