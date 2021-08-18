package com.example.musicplayer.MusicOn.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//https://mp3.zing.vn/xhr/recommend?type=audio&id=ZW67OIA0
class ApiConnection {
    var BaseURL = "https://mp3.zing.vn/"
    fun call() : ApiService {
        return Retrofit.Builder()
            .baseUrl(BaseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}