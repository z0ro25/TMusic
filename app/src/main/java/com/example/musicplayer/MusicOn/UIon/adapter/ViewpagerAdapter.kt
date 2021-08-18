package com.example.musicplayer.MusicOn.UIon.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.musicplayer.MusicOn.UIon.Fragment.FavoriteFragment
import com.example.musicplayer.MusicOn.UIon.Fragment.Homefragment
import com.example.musicplayer.MusicOn.UIon.Fragment.TopsongFragment

class ViewpagerAdapter(fm: FragmentManager, behavior: Int) :
    FragmentStatePagerAdapter(fm, behavior) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> return Homefragment()

            1 -> return TopsongFragment()

            2 -> return FavoriteFragment()

            else -> return Homefragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> return "Home"

            1 -> return "Top"

            2 -> return "Favorite"

            else -> return ""
        }
        return super.getPageTitle(position)
    }
}