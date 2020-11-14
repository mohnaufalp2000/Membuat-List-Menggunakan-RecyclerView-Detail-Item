package com.example.cafesurabaya.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cafesurabaya.R
import com.example.cafesurabaya.model.Favorite
import com.example.cafesurabaya.model.Near
import kotlinx.android.synthetic.main.layout_favorite.view.*
import kotlinx.android.synthetic.main.layout_near.view.*

class AdapterFavorite(private val listAdapter : ArrayList<Favorite>) : RecyclerView.Adapter<AdapterFavorite.ViewHolder>() {
    private lateinit var onItemClickCallback: AdapterFavorite.OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Favorite)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(favorite : Favorite){
            with(itemView){
                Glide.with(itemView.context)
                    .load(favorite.img)
                    .into(img_favorite)

                txt_name_favorite.text = favorite.name
                txt_place_favorite.text = favorite.place
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_favorite, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listAdapter[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listAdapter[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listAdapter.size
}