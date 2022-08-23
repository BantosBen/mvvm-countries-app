package com.nerdpros.mvvm_counties_app.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nerdpros.mvvm_counties_app.R

/**
 * @Author: Angatia Benson
 * @Date: 23/08/2022
 * Copyright (c) 2022 Bantechnis
 */

fun getProgressDrawable(_context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(_context).apply {
        strokeWidth = 3f
        centerRadius = 30f
        start()
    }
}

fun ImageView.loadImage(url: String?, progressDrawable: CircularProgressDrawable) {
    val options = RequestOptions
        .placeholderOf(progressDrawable)
        .error(R.mipmap.ic_launcher)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}