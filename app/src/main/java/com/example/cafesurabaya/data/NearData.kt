package com.example.cafesurabaya.data

import com.example.cafesurabaya.R
import com.example.cafesurabaya.model.Near

object NearData {
    private val nearName = arrayOf(
        "Angop",
        "Tampan Coffee",
        "Kofibrik",
        "Warkop Hilal",
        "Starbucks"
    )

    private val nearDistance = arrayOf(
        "1 km",
        "0.8 km",
        "0.8 km",
        "1 km",
        "1.3 km"
    )

    private val nearPlace = arrayOf(
        "Jl. Biliton No.43, Gubeng, Kec. Gubeng, Kota SBY, Jawa Timur 60281",
        "Jl. Slamet No.16, Ketabang, Kec. Genteng, Kota SBY, Jawa Timur 60272",
        "Jl. Raya Mulyosari No.163, Kalisari, Kec. Mulyorejo, Kota SBY, Jawa Timur 60113",
        "Pakuwon Square AK 2 No. 3 No. 100 Wonokromo, Jl. Yono Suwoyo, Lidah Wetan, Kec. Lakarsantri, Kota SBY, Jawa Timur 60213",
        "Jl. Tegalsari No.24, Kedungdoro, Kec. Tegalsari, Kota SBY, Jawa Timur 60262"
    )

    private val nearImg = intArrayOf(
        R.drawable.angop,
        R.drawable.tampan,
        R.drawable.kofibrik,
        R.drawable.hilal,
        R.drawable.starbucks
    )

    val listData : ArrayList<Near>
        get() {
            val list = ArrayList<Near>()
            for (position in nearName.indices){
                var nearData = Near()
                nearData.name = nearName[position]
                nearData.distance = nearDistance[position]
                nearData.place = nearPlace[position]
                nearData.img = nearImg[position]
                list.add(nearData)
            }
            return  list
        }
}