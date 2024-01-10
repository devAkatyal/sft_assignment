package com.sft.sftassignment.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageUrlPath")
fun setImageUrlPath(
    imageView: ImageView,
    url: String
) {
    if (!TextUtils.isEmpty(url)) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}