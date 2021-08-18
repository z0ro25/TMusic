package com.example.musicplayer

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.musicplayer.MusicOn.UIon.Activity.MusiconlayoutACtivity
import com.t3h.mvvm.ui.base.BaseActivity
import kotlinx.android.synthetic.main.first_layout.*

class MainActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_layout)
        btn_MsOn.setOnClickListener(this)
        btn_MsOf.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_MsOn -> {
                var intent = Intent(this, MusiconlayoutACtivity::class.java)
                startActivity(intent)
            }
            R.id.btn_MsOf -> {
                var intent = Intent(this, Main_LayoutActivity::class.java)
                startActivity(intent)
            }
        }
    }

}