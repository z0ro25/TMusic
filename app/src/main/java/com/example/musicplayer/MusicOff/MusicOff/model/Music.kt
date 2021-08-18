package com.example.musicplayer.MusicOff.MusicOff.model

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable

data class Music(
        var Name : String?,
        var artist : String?,
        var image : Uri?,
        var duration :String?,
        var path : String?
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readParcelable(Uri::class.java.classLoader),
                parcel.readString(),
                parcel.readString()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(Name)
                parcel.writeString(artist)
                parcel.writeParcelable(image, flags)
                parcel.writeString(duration)
                parcel.writeString(path)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Music> {
                override fun createFromParcel(parcel: Parcel): Music {
                        return Music(parcel)
                }

                override fun newArray(size: Int): Array<Music?> {
                        return arrayOfNulls(size)
                }
        }
}
