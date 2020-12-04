package com.hsd.contest.spain.kantoteksto.model

import java.io.*
import java.nio.ByteBuffer

class ListeningCard() {

    val shortTermScore = InterestScore(0.9)
    val longTermScore = InterestScore(0.98)
    var starred: Boolean = false

    //statistics on performance

    fun flipStarred(){
        starred = !starred
    }

    fun writeTo(file: File){
        DataOutputStream(FileOutputStream(file)).use {
            with(it){
                it.writeDouble(shortTermScore.score)
                it.writeDouble(longTermScore.score)
                it.writeBoolean(starred)
            }
        }
    }

    constructor(file: File) : this() {
        DataInputStream(FileInputStream(file)).use {
            with(it){
                shortTermScore.score = it.readDouble()
                longTermScore.score = it.readDouble()
                starred = it.readBoolean()
            }
        }
    }
}