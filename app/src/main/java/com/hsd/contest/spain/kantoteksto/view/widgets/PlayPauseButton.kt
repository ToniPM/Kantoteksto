package com.hsd.contest.spain.kantoteksto.view.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hsd.contest.spain.kantoteksto.R

private enum class PlayState { PLAYING, PAUSED }
private val flippedState = mapOf(PlayState.PLAYING to PlayState.PAUSED,
        PlayState.PAUSED to PlayState.PLAYING)

private val animTo = mapOf(PlayState.PLAYING to R.drawable.pause_to_play_animation,
        PlayState.PAUSED to R.drawable.play_to_pause_animation)
private val iconAt = mapOf(PlayState.PLAYING to R.drawable.play_icon,
        PlayState.PAUSED to R.drawable.pause_icon)




class PlayPauseButton(context: Context, attrs: AttributeSet) : FloatingActionButton(context, attrs), View.OnClickListener{

    private var state = PlayState.PAUSED

    init{
        setOnClickListener(this)
        this.background = ContextCompat.getDrawable(this.context, iconAt[state]!!)
    }

    override fun onClick(v: View?) {
        flipState()
    }

    fun flipState(){
        state = flippedState[state]!!
        this.background = ContextCompat.getDrawable(this.context, iconAt[state]!!)
    }
}