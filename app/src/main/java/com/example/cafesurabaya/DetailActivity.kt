package com.example.cafesurabaya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val NAME = "name"
        const val PLACE = "place"
        const val IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val name = intent.getStringExtra(NAME)
        val place = intent.getStringExtra(PLACE)
        val img = intent.getIntExtra(IMAGE, 0)

        detail_name.text = name
        detail_place.text = place

        Glide.with(this)
            .load(img)
            .into(img_detail)
    }
}