package com.example.musicplayer.MusicOff.MusicOff.ui.test

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.view.View
import android.widget.SeekBar
import com.example.musicplayer.R
import com.example.musicplayer.MusicOff.MusicOff.model.Music
import com.example.musicplayer.Main_LayoutActivity
import com.t3h.mvvm.ui.base.BaseActivity
import kotlinx.android.synthetic.main.music_detail.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

// 1 namimg convention
// ten class
// ten ham
// ten bien

class MusicDetailActivity : BaseActivity(), View.OnClickListener, MusicPlayer.IMusicPlayer {
    private var listsong: ArrayList<Music>? = null
    private var songs: Music? = null
    private var pos = 0
    private var repeat : Boolean = false
    var handler: Handler? = null

    companion object {
        private var musicmanager: MusicPlayer? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.music_detail)
        btn_back.setOnClickListener(this)
        skip_back.setOnClickListener(this)
        skip_next.setOnClickListener(this)
        player.setOnClickListener(this)
        NameDT.ellipsize = TextUtils.TruncateAt.MARQUEE
        ArtistDT.ellipsize = TextUtils.TruncateAt.MARQUEE
        NameDT.isSelected = true
        ArtistDT.isSelected = true
        if (musicmanager == null) {
            musicmanager = MusicPlayer(this)
        }
        getparam()
        preparemusic()
        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                musicmanager!!.seekSongTo(seekBar!!.progress)
            }

        })
        initseekbar()
    }

    private fun preparemusic() {
        musicmanager?.setDataSong(songs!!.path!!)
        musicmanager?.startSong()
//        player.setImageResource(R.drawable.baseline_play_circle_outline_black_24dp)
        Max_timer.text = makeTextTime(musicmanager!!.getDurationSong().toLong())
    }

    private fun makeTextTime(duration: Long): String {
        var time = ""
        var Hour = duration / (1000 * 60 * 60)
        var min = (duration / (1000 * 60)) % (60)
        var sec = (duration / (1000)) % 60
        if (duration >= (1000 * 60 * 60)) {
            time += "$Hour:"
        }
        time += if (min < 10) {
            "0$min:"
        } else {
            "$min:"
        }
        time += if (sec < 10) {
            "0$sec"
        } else {
            "$sec"
        }
        return time

    }

    override fun onClick(v: View) {
        var nextpos = pos + 1
        var prepos = pos - 1
        when (v.id) {
            R.id.btn_back -> {
                var inten = Intent(this, Main_LayoutActivity::class.java)
                startActivity(inten)
            }
            R.id.player -> {
                if (musicmanager!!.isSongPlaying() == true) {
                    musicmanager?.pauseSong()
                    player.setImageResource(R.drawable.baseline_play_circle_outline_black_24dp)
                } else {
                    player.setImageResource(R.drawable.baseline_pause_circle_outline_black_24dp)
                    musicmanager?.startSong()
                }
            }
            R.id.skip_next -> {
//                if (nextpos == listsong!!.size)
//                    nextpos = 0
//                UpdatesongUI(nextpos)
                if (repeat == false) {
                    if (nextpos == listsong!!.size)
                        nextpos = 0
                    UpdatesongUI(nextpos)
                } else {
                    var posst = musicmanager!!.currentPosition
                    UpdatesongUI(posst)
                }

            }
            R.id.skip_back -> {
                if (prepos < 0)
                    prepos = listsong!!.size - 1
                UpdatesongUI(prepos)
            }
            R.id.btn_shuffle -> {
                var random : Random = Random()
                var randompos = random.nextInt(listsong!!.size)

            }
            R.id.btn_repeat -> {
                if (repeat == false) btn_repeat.setImageResource(R.drawable.baseline_repeat_on_black_24dp)
                else {
                    repeat = true
                    btn_repeat.setImageResource(R.drawable.baseline_repeat_black_24dp)
                }
            }
        }
    }


    private fun UpdatesongUI(newpos: Int) {
        songs = listsong!![newpos]
        pos = newpos
        musicmanager!!.doNextOrPrev(songs!!)
        NameDT.text = songs!!.Name
        ArtistDT.text = songs!!.artist
        Max_timer.text = makeTextTime(musicmanager!!.getDurationSong().toLong())
        animationImg(img_musicDL, 1000)
        checkIconPlay()
        initseekbar()
        handler = null

    }

    private fun initseekbar() {
        seekbar.max = musicmanager!!.getDurationSong()
        // decrept roi k dc dung
        Handler(Looper.getMainLooper()).postDelayed(object : Runnable {
            override fun run() {
                try {
                    seekbar.progress = musicmanager!!.getCurrentPositionSong()
                    timer.text = makeTextTime(musicmanager!!.getCurrentPositionSong().toLong())
                    handler!!.postDelayed(this, 1000)
                } catch (e: Exception) {
                    seekbar.progress = 0
                }
            }
        }, 0)
        /*handler =Handler()
        handler!!.postDelayed(object : Runnable{
            override fun run() {
                try {
                    seekbar.progress = musicmanager!!.getCurrentPositionSong()
                    timer.text = makeTextTime(musicmanager!!.getCurrentPositionSong().toLong())
                    handler!!.postDelayed(this,1000)
                }catch (e: Exception){
                    seekbar.progress = 0
                }
            }
        },0)*/

    }

    private fun animationImg(v: View, duration: Long) {
        var animator = ObjectAnimator.ofFloat(img_musicDL, "rotation", 0f, 360f)
        animator.duration = duration
        var aniSet = AnimatorSet()
        aniSet.playTogether(animator)
        aniSet.start()
    }

    fun getparam() {
        var inten = intent
        listsong = inten.getParcelableArrayListExtra("listsong")
        pos = inten.getIntExtra("poss", 0)
        songs = listsong?.get(pos)
        NameDT.text = songs!!.Name
        ArtistDT.text = songs!!.artist
        Max_timer.text = songs!!.duration
    }

    private fun checkIconPlay() {
        if (musicmanager!!.isSongPlaying() == true) {
            player.setImageResource(R.drawable.baseline_pause_circle_outline_black_24dp)
        } else {
            player.setImageResource(R.drawable.baseline_play_circle_outline_black_24dp)
        }
    }

    override fun autoNextSong() {
        var nexsong = pos + 1
        if (nexsong == listsong!!.size) {
            nexsong = 0
        }
        UpdatesongUI(nexsong)
    }
}


