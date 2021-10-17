package com.example.glowroadassgnapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.glowroadassgnapp.R
import com.example.glowroadassgnapp.databinding.LayoutPhotoBinding
import com.example.glowroadassgnapp.models.Photo

class GrPhotoAdpter(
    private val photos: List<Photo>,
    private val context: Context
) : PagingDataAdapter<Photo, GrPhotoAdpter.GRPhotoViewHolder>(DiffUtilCallback()) {

    inner class GRPhotoViewHolder(
        val binding : LayoutPhotoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GRPhotoViewHolder {
        return GRPhotoViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_photo,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: GRPhotoViewHolder, position: Int) {
        holder.binding.photo = photos.get(position)
        Glide.with(context)
            .load(photos.get(position).url_q)
            .centerCrop()
            .into(holder.binding.ivPhoto)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    class DiffUtilCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.equals(newItem)
        }

    }
}