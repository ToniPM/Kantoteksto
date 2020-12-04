package com.hsd.contest.spain.kantoteksto.data

import com.hsd.contest.spain.kantoteksto.model.Lyrics
import com.hsd.contest.spain.kantoteksto.model.SongId

interface LyricsDAO {

    operator fun get(songId: SongId): Lyrics

    operator fun set(songId: SongId, lyrics : Lyrics)

}