package com.example.musicplayer.model.MusicOff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.musicplayer.R
import com.example.musicplayer.db.entity.Music
import com.example.musicplayer.ui.test.fragment.ListMusicFragment
import com.example.musicplayer.ui.test.fragment.MusicDetailFragment
import com.example.musicplayer.ui.test.fragment.comunicater
import com.t3h.mvvm.ui.base.BaseActivity
import com.t3h.mvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        opentFirstFragment(ListMusicFragment::class.java)
    }

    fun opentFirstFragment(clazz: Class<out BaseFragment>) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame,clazz.newInstance(),clazz.name)
            .commit()
    }

}