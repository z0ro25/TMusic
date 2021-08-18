package com.example.musicplayer.MusicOn.UIon.Fragment

import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicplayer.MusicOn.Api.ApiConnection
import com.example.musicplayer.MusicOn.Api.ApiService
import com.example.musicplayer.MusicOn.UIon.adapter.HomefragmentAdapter
import com.example.musicplayer.MusicOn.modelOn.Items
import com.example.musicplayer.MusicOn.modelOn.Musicon
import com.example.musicplayer.R
import com.t3h.mvvm.ui.base.BaseFragment
import kotlinx.android.synthetic.main.homfragment_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Homefragment : BaseFragment(), HomefragmentAdapter.IMusicon {
    private var ms = mutableListOf<Items>()
    var callApi: Call<Musicon>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.homfragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        RC_newsong.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        RC_newsong.adapter = HomefragmentAdapter(this, ms)
        addMusic()

    }

    fun addMusic() {
//        val RF = Retrofit.Builder()
//            .baseUrl("https://mp3.zing.vn/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiService::class.java)
//        callApi = RF
//        callApi?.enqueue(object : Callback<Musicon> {
//            override fun onResponse(call: Call<Musicon>, response: Response<Musicon>) {
//                response.let { response ->
//                    var data = response.body()
//
//                }
//            }
//
//            override fun onFailure(call: Call<Musicon>, response: Throwable) {
//
//            }
//        })
    }

    override fun onClickItiem(position: Int) {

    }

}