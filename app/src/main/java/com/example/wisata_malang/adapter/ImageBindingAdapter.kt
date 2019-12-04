package com.example.wisata_malang.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.wisata_malang.R

object ImageBindingAdapter {
    @JvmStatic
    @BindingAdapter("setImageUrl")
    fun setImageUrl(view: ImageView, url: String){
        Glide.with(view.context)
            .load(url)
            .error(R.drawable.ic_image_black_72dp)
            .placeholder(R.drawable.ic_image_black_72dp)
            .into(view)
    }
}