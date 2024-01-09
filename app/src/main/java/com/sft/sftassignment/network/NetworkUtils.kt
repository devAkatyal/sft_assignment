package com.sft.sftassignment.network

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager

object NetworkUtils {
    const val BASE_URL="https://picsum.photos/v2/"
    fun isNetworkConnected(activity: Activity): Boolean {
        val cm = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isConnected
    }
}