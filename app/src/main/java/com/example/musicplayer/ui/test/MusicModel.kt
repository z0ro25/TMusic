package com.example.musicplayer.ui.test

import androidx.lifecycle.MutableLiveData
import com.example.musicplayer.db.entity.Music

class MusicModel {
    val musicres = MutableLiveData<MutableList<Music>>()

}
