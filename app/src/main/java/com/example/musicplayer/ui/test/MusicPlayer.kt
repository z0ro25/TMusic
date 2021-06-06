package com.example.musicplayer.ui.test

import android.media.MediaPlayer
import com.example.musicplayer.db.entity.Music

// hoc may cai kotlin .let .run . apply con gi nua ko

class MusicPlayer:  MediaPlayer, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {
    private var mediaPlayer:MediaPlayer?=null
    private var inter:IMusicPlayer

    constructor(inter: IMusicPlayer) : super() {
        this.inter = inter
    }

    fun setDataSong(path:String){
        releaseSong()
        mediaPlayer = MediaPlayer()
        mediaPlayer?.let {
            it.setOnErrorListener(this)
            it.setDataSource(path)
            it.prepare()
            it.setOnCompletionListener(this)
        }

    }
    fun startSong(){
        mediaPlayer?.start()
    }
    fun pauseSong(){
        mediaPlayer?.pause()
    }
    private fun stopSong(){
        mediaPlayer?.stop()
    }
    private fun releaseSong(){
        mediaPlayer?.release()
    }

    fun isSongPlaying(): Boolean? {
        return mediaPlayer?.let{
            it.isPlaying
        }
    }
    fun doNextOrPrev(song: Music){
        if(isSongPlaying() == true){
            stopSong()
        }
        setDataSong(song!!.path!!)
        startSong()
    }
    fun getDurationSong():Int{
        return mediaPlayer!!.duration
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        return true
    }

    fun seekSongTo(progress: Int) {
        mediaPlayer!!.seekTo(progress)
    }

    fun getCurrentPositionSong(): Int {
        return  mediaPlayer!!.currentPosition
    }

    override fun onCompletion(mp: MediaPlayer?) {
        inter.autoNextSong()
    }

    interface IMusicPlayer {
        fun autoNextSong()
    }
}
