package com.example.musicplayer.MusicOn.modelOn

data class Items(
    var id : String? = null,
    var name : String? = null,
    var title : String? = null,
    var code : String? = null,
    var isoffical : String? = null,
    var isWorldWide : Boolean? = null,
    var playlist_id : String? = null,
    var artists : Artists? = null,
    var performer : String? = null,
    var type : String? = null,
    var link : String? = null,
    var lyric : String? = null,
    var thumbnail : String? = null,
    var duration : String? = null,
    var order : String? = null
)
