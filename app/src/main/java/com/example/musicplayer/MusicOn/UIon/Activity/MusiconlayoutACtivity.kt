package com.example.musicplayer.MusicOn.UIon.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.musicplayer.MainActivity
import com.example.musicplayer.MusicOn.UIon.adapter.ViewpagerAdapter
import com.example.musicplayer.R
import com.t3h.mvvm.ui.base.BaseActivity
import kotlinx.android.synthetic.main.musiconactivity_layout.*

class MusiconlayoutACtivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.musiconactivity_layout)
        btn_exit.setOnClickListener(this)
        var vpadp = ViewpagerAdapter(supportFragmentManager,FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        vp_main.adapter = vpadp
        tl_menu.setupWithViewPager(vp_main)
    }

    override fun onClick(v: View) {
        when  (v.id){
            R.id.btn_exit->{
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

        }
    }
}

