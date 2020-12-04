package com.hsd.contest.spain.kantoteksto.model

import java.io.*
import java.util.*

class Lyrics () {
    val inLanguage = EnumMap<Language,Array<String>>(Language::class.java)

    fun writeTo(file: File){
        //ObjectOutputStream(DataOutputStream(FileOutputStream(file))).use {
        ObjectOutputStream(FileOutputStream(file)).use {
            with(it){
                it.writeObject(inLanguage)
            }
        }
    }

    constructor(file: File) : this() {
        ObjectInputStream(FileInputStream(file)).use {
            with(it){
                val tempMap = it.readObject() as EnumMap<Language,Array<String>>
                for((language,lyrics) in tempMap.entries){
                    inLanguage[language] = lyrics
                }
            }
        }
    }
}