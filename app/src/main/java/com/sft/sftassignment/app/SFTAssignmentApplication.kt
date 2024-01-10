package com.sft.sftassignment.app


import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.os.Handler
import androidx.multidex.MultiDex
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import dagger.hilt.android.HiltAndroidApp
import java.util.Locale


@HiltAndroidApp
class SFTAssignmentApplication : Application() {
    companion object {
        @JvmStatic
        var applicationHandler: Handler? = null

        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        var context: Context? = null

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
        Logger.addLogAdapter(AndroidLogAdapter())
        applicationHandler = applicationContext?.mainLooper?.let { Handler(it) }
        setAppLocale(Locale("en"))
    }

    private fun setAppLocale(locale: Locale) {
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }

}