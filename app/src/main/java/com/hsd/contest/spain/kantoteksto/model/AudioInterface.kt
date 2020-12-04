package com.hsd.contest.spain.kantoteksto.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Duration

interface AudioInterface {
    fun play()
    fun stop()
    fun getTime(): Duration
    fun setTime(duration: Duration)
    fun getLength(): Duration

    fun jumpBack5s(){
        setTime(getTime() - Duration.ofSeconds(5))
    }

    fun jumpForward15s(){
        setTime(getTime() + Duration.ofSeconds(15))
    }
}