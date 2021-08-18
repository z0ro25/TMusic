package com.example.musicplayer.MusicOn.UIon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.MusicOn.modelOn.Items
import com.example.musicplayer.R
import kotlinx.android.synthetic.main.itiem_music.view.*

class HomefragmentAdapter(private var inter: IMusicon , list: MutableList<Items>) :RecyclerView.Adapter<HomefragmentAdapter.HomeFragmentViewholder>(){
    private var listmusicon = list
    interface IMusicon {
        fun onClickItiem(position : Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeFragmentViewholder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.itiem_music, parent, false)
        return HomeFragmentViewholder(itemview,inter)
    }

    override fun onBindViewHolder(holder: HomeFragmentViewholder, position: Int) {
        holder.onBindData(listmusicon[position])
    }

    class HomeFragmentViewholder(
        itemView: View, inter: IMusicon
    ) : RecyclerView.ViewHolder(itemView) {
        private lateinit var music: Items

        init {
            itemView.setOnClickListener {
                inter.onClickItiem(adapterPosition)
            }
        }

        fun onBindData(music: Items) {
            this.music = music
            itemView.name.text = music.name
            itemView.artist.text = music.artists.toString()
        }
    }

    override fun getItemCount() = listmusicon.size
}