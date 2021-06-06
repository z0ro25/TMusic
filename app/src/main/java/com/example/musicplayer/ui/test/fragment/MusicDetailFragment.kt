package com.example.musicplayer.ui.test.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import com.example.musicplayer.R
import com.example.musicplayer.db.entity.Music
import com.t3h.mvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.itiem_music.*
import kotlinx.android.synthetic.main.music_detail.*

class MusicDetailFragment : BaseFragment(), View.OnClickListener {
    private var music = mutableListOf<Music>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.music_detail,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_back.setOnClickListener(this)
        player.setOnClickListener(this)
        skip_back.setOnClickListener(this)
        skip_next.setOnClickListener(this)
        img_musicDL.setImageResource(R.drawable.a)
        getparam(music)
    }

    private fun getparam(songs : MutableList<Music>) {
        music = songs
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_back->{
                val list = ListMusicFragment()
                val transaction: FragmentTransaction =  fragmentManager!!.beginTransaction()
                transaction.replace(R.id.frame,list).commit()
            }
            R.id.player->{

            }
            R.id.skip_next->{

            }
            R.id.skip_back->{

            }
        }

    }
}