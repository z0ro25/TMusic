package com.example.musicplayer.MusicOn.Api

import com.example.musicplayer.MusicOn.modelOn.Musicon
import retrofit2.Call
import retrofit2.http.GET

interface ApiService : Call<Musicon> {
//    https://mp3.zing.vn/xhr/recommend?type=audio&id=ZW67OIA0
    @GET ("xhr/recommend?type=audio&id=ZW67OIA0")
    fun callApi() : Call<Musicon>
}