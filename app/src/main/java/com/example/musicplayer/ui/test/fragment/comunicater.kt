package com.example.musicplayer.ui.test.fragment

import com.example.musicplayer.db.entity.Music

interface comunicater {
    fun sendData(listms : ArrayList<Music>)
}