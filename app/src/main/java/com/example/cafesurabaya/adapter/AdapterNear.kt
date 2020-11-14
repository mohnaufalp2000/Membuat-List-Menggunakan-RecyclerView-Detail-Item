package com.example.cafesurabaya.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cafesurabaya.R
import com.example.cafesurabaya.model.Near
import kotlinx.android.synthetic.main.layout_near.view.*

class AdapterNear(private val listAdapter : ArrayList<Near>) : RecyclerView.Adapter<AdapterNear.ViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Near)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(near : Near){
            with(itemView){
                Glide.with(itemView.context)
                    .load(near.img)
                    .into(img_near)

                txt_name_near.text = near.name
                txt_distance_near.text = near.distance
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_near, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listAdapter[position])
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listAdapter[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int = listAdapter.size
}