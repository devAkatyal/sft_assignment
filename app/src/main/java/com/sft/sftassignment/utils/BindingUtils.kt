package com.sft.sftassignment.utils

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("app:setImageUrl")
fun setImageUrl(
    imageView: ImageView,
    url: String
) {
    if (!TextUtils.isEmpty(url)) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }
}