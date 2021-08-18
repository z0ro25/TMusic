package com.example.musicplayer

import android.os.Bundle
import com.example.musicplayer.MusicOff.MusicOff.ui.test.fragment.ListMusicFragment
import com.t3h.mvvm.ui.base.BaseActivity
import com.t3h.mvvm.ui.base.BaseFragment

class Main_LayoutActivity : BaseActivity() {
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