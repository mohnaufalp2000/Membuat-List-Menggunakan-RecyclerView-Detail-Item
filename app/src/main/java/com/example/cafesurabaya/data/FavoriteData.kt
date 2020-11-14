package com.example.cafesurabaya.data

import com.example.cafesurabaya.R
import com.example.cafesurabaya.model.Favorite
import com.example.cafesurabaya.model.Near

object FavoriteData {

    private val favoriteName = arrayOf(
        "Joybox",
        "Aiola Eatery",
        "Janji Jiwa",
        "Kudos Cafe",
        "Ada Apa Dengan Kopi"
    )

    private val favoritePlace = arrayOf(
        "Jl. Biliton No.43, Gubeng, Kec. Gubeng, Kota SBY, Jawa Timur 60281",
        "Jl. Slamet No.16, Ketabang, Kec. Genteng, Kota SBY, Jawa Timur 60272",
        "Jl. Raya Mulyosari No.163, Kalisari, Kec. Mulyorejo, Kota SBY, Jawa Timur 60113",
        "Pakuwon Square AK 2 No. 3 No. 100 Wonokromo, Jl. Yono Suwoyo, Lidah Wetan, Kec. Lakarsantri, Kota SBY, Jawa Timur 60213",
        "Jl. Tegalsari No.24, Kedungdoro, Kec. Tegalsari, Kota SBY, Jawa Timur 60262"
    )

    private val favoriteImg = intArrayOf(
        R.drawable.joybox,
        R.drawable.aiola,
        R.drawable.janjijiwa,
        R.drawable.kudos,
        R.drawable.aadk
    )

    val favoriteData : ArrayList<Favorite>
        get() {
            val list = ArrayList<Favorite>()
            for (position in FavoriteData.favoriteName.indices){
                var favorite = Favorite()
                favorite.name = favoriteName[position]
                favorite.place = favoritePlace[position]
                favorite.img = favoriteImg[position]
                list.add(favorite)
            }
            return  list
        }
}