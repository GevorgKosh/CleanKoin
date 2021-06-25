package com.example.empty.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.bumptech.glide.Glide
import com.example.empty.R

class BindingAdapters {

//    @BindingConversion
//    fun setVisibility(state: Boolean): Int {
//        return if (state) View.VISIBLE else View.GONE
//    }

    @BindingAdapter("visible")
    fun View.setVisible(state: Boolean) = if (state) View.VISIBLE else View.GONE


    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url: String?) {
        if (url != null) {
            Glide.with(imageView.context)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)
        }
    }
}