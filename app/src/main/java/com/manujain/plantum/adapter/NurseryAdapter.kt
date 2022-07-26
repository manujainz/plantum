package com.manujain.plantum.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.manujain.plantum.R
import com.manujain.plantum.models.NurseryPlant

class NurseryAdapter(context: Context): ListAdapter<NurseryPlant, NurseryAdapter.NurseryViewHolder>(NurseryPlantDiffCallback) {

    private var mContext: Context

    init { mContext = context }

    class NurseryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val plantImage = itemView.findViewById<ImageView>(R.id.plant_image)
        private val plantText = itemView.findViewById<TextView>(R.id.plant_text)

        fun bind(context: Context, plant: NurseryPlant) {
            plantText.text = plant.name
            Glide.with(context)
                .load(plant.imageLink.toString())
                .placeholder(R.mipmap.ic_launcher)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(plantImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NurseryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nursery_plant_item, parent, false)
        return NurseryViewHolder(view)
    }

    override fun onBindViewHolder(holder: NurseryViewHolder, position: Int) {
        val plant = getItem(position)
        holder.bind(context = mContext, plant)
    }
}

object NurseryPlantDiffCallback : DiffUtil.ItemCallback<NurseryPlant>() {
    override fun areItemsTheSame(oldItem: NurseryPlant, newItem: NurseryPlant): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: NurseryPlant, newItem: NurseryPlant): Boolean {
        return oldItem.id == newItem.id
    }
}