package com.hsd.contest.spain.kantoteksto.model

class InterestScore(private val memoryFactor: Double) : Comparable<InterestScore>{

    var score: Double = 0.0

    private val correctedScore: Double
        get() = score*(1-memoryFactor)

    constructor(memoryFactor: Double, score: Double) : this(memoryFactor) {
        this.score = score
    }

    fun increment(){
        score = memoryFactor*score + 1
    }

    fun decrement(){
        score *= memoryFactor
    }

    override fun compareTo(other: InterestScore): Int {
        return if (this.memoryFactor == other.memoryFactor){
            this.score.compareTo(other.score)
        } else {
            this.correctedScore.compareTo(other.correctedScore)
        }
    }
}
