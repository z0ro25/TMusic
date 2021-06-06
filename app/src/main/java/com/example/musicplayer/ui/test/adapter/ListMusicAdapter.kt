package com.example.musicplayer.ui.test.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.musicplayer.R

import com.example.musicplayer.db.entity.Music
import kotlinx.android.synthetic.main.itiem_music.view.*
import kotlinx.android.synthetic.main.music_detail.view.*
import java.io.File
// no contructor ko tạo second contructor ở dưới như thế để ntn này luôn ok
class ListMusicAdapter (private val inter: IlistMusic, list: MutableList<Music>) :
    RecyclerView.Adapter<ListMusicAdapter.listMusicViewHolder>() {
    private var listMusic = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listMusicViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.itiem_music, parent, false)
        return listMusicViewHolder(itemview, inter)
    }

    override fun onBindViewHolder(holder: listMusicViewHolder, position: Int) {
        holder.onBindData(listMusic[position])
    }

    interface IlistMusic {
        fun onClickItem(position: Int)
    }

    class listMusicViewHolder(
            itemView: View, inter: IlistMusic
    ) : RecyclerView.ViewHolder(itemView) {
        private lateinit var music: Music

        init {
            itemView.setOnClickListener {
                inter.onClickItem(adapterPosition)
            }
        }

        fun onBindData(music: Music) {
            this.music = music
            itemView.name.text = music.Name
            itemView.artist.text = music.artist
        }
    }

    override fun getItemCount() = listMusic.size

}