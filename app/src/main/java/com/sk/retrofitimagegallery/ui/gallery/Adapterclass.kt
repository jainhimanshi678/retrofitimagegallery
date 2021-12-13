package com.sk.retrofitimagegallery.ui.gallery

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.sk.retrofitimagegallery.data.ModelUnsplashPhoto
import com.sk.retrofitimagegallery.databinding.ItemUnsplashPhotoBinding
import com.sk.retrofitimagegallery.R

class Adapterclass: PagingDataAdapter<ModelUnsplashPhoto, Adapterclass.PhotoViewHolder>(
    PHOTO_COMPARATOR) {

    class PhotoViewHolder(private val biinding: ItemUnsplashPhotoBinding) :
        RecyclerView.ViewHolder(biinding.root) {
            fun bind(photo:ModelUnsplashPhoto){
                biinding.apply {
                    Glide.with(itemView)
                        .load(photo.urls.regular)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .error(R.drawable.ic_baseline_error_24)
                        .into(imageView)
                    tvUserName.text=photo.user.username
                }
            }
    }

    companion object {
        private val PHOTO_COMPARATOR = object : DiffUtil.ItemCallback<ModelUnsplashPhoto>() {
            override fun areItemsTheSame(
                oldItem: ModelUnsplashPhoto,
                newItem: ModelUnsplashPhoto
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ModelUnsplashPhoto,
                newItem: ModelUnsplashPhoto
            ) = oldItem == newItem

        }
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val curentitem=getItem(position)
        if(curentitem!=null){
            holder.bind(curentitem)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding=ItemUnsplashPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhotoViewHolder(binding)
    }
}