package com.example.cafesurabaya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cafesurabaya.adapter.AdapterFavorite
import com.example.cafesurabaya.adapter.AdapterNear
import com.example.cafesurabaya.data.FavoriteData
import com.example.cafesurabaya.data.NearData
import com.example.cafesurabaya.model.Favorite
import com.example.cafesurabaya.model.Near
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var listNear : ArrayList<Near> = arrayListOf()
    private var listFavorite : ArrayList<Favorite> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNearList()
        showFavoriteList()
    }

    private fun showFavoriteList() {
        listFavorite.apply {
            clear()
            addAll(FavoriteData.favoriteData)
        }
        val adapterFavorite = AdapterFavorite(listFavorite)
        rv_favorite.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = adapterFavorite
        }
        adapterFavorite.setOnItemClickCallback(object : AdapterFavorite.OnItemClickCallback {
            override fun onItemClicked(data: Favorite) {
                showSelectedFavorite(data)
            }
        })
    }

    private fun showNearList() {
        listNear.apply {
            clear()
            addAll(NearData.listData)
        }
        val adapterNear = AdapterNear(listNear)
        rv_near.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity,  LinearLayoutManager.HORIZONTAL, false)
            adapter = adapterNear
        }

        adapterNear.setOnItemClickCallback(object : AdapterNear.OnItemClickCallback {
            override fun onItemClicked(data: Near) {
                showSelectedNear(data)
            }
        })
    }

    private fun showSelectedNear(data: Near) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.apply {
            putExtra(DetailActivity.NAME, data.name)
            putExtra(DetailActivity.PLACE, data.place)
            putExtra(DetailActivity.IMAGE, data.img)
        }
        startActivity(intent)
    }

    private fun showSelectedFavorite(data: Favorite) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.apply {
            putExtra(DetailActivity.NAME, data.name)
            putExtra(DetailActivity.PLACE, data.place)
            putExtra(DetailActivity.IMAGE, data.img)
        }
        startActivity(intent)
    }
}