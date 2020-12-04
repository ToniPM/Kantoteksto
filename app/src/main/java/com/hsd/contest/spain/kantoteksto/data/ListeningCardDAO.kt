package com.hsd.contest.spain.kantoteksto.data

import com.hsd.contest.spain.kantoteksto.model.ListeningCard
import com.hsd.contest.spain.kantoteksto.model.SongId

interface ListeningCardDAO {

    operator fun get(songId: SongId): ListeningCard

    operator fun set(songId: SongId, listeningCard : ListeningCard)

    //TODO( all listening cards (regular and iterator))
    //fun getAllListeningCards(): Array<ListeningCard>
}