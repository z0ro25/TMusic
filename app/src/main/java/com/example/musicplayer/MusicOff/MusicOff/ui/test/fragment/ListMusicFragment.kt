package com.example.musicplayer.MusicOff.MusicOff.ui.test.fragment

import android.content.ContentUris
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.MainActivity
import com.example.musicplayer.R
import com.example.musicplayer.MusicOff.MusicOff.model.Music
import com.example.musicplayer.MusicOff.MusicOff.ui.test.adapter.ListMusicAdapter
import com.example.musicplayer.MusicOff.MusicOff.ui.test.MusicDetailActivity
import com.t3h.mvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.list_music.*

class ListMusicFragment : BaseFragment(), ListMusicAdapter.IlistMusic, View.OnClickListener {
    private var musicfile = mutableListOf<Music>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        RC_lm.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        RC_lm.adapter = ListMusicAdapter(this, musicfile)
        loadmussic()
        btn_back.setOnClickListener(this)
    }

    private fun loadmussic() {
        val c = context!!.contentResolver
            .query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null, null)
        if (c == null) return
        c.moveToFirst()
        val indexpath = c.getColumnIndex(MediaStore.Audio.Media.DATA)
        val indexname = c.getColumnIndex(MediaStore.Audio.Media.TITLE)
        val indexab = c.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID)
        val indexartist = c.getColumnIndex(MediaStore.Audio.Media.ARTIST)
        val indexduration = c.getColumnIndex(MediaStore.Audio.Media.DURATION)
        while (!c.isAfterLast) {
            val path = c.getString(indexpath)
            val name = c.getString(indexname)
            val artist = c.getString(indexartist)
            val ab = c.getLong(indexab)
            val duration = c.getString(indexduration)
            val uri =
                ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), ab)
            musicfile.add(Music(name, artist, uri, duration, path))
            c.moveToNext()
        }
        RC_lm.adapter?.notifyDataSetChanged()
    }


    override fun onClickItem(position: Int) {
        this.onSaveInstanceState(Bundle())
        val intent = Intent(activity!!.application, MusicDetailActivity::class.java)
        intent.putExtra("listsong", ArrayList(musicfile))
        intent.putExtra("poss", position)
        startActivity(intent)

//        val musicDetail = MusicDetailFragment()
//        val transaction: FragmentTransaction =  fragmentManager!!.beginTransaction()
//        transaction.replace(R.id.frame,musicDetail).commit()

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_back -> {
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

}